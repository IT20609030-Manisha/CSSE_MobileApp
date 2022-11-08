package com.example.dd;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

/**
 * Adding a new product to the system
 * The product can be inserted by filling the form with all fields
 */
public class AddProduct extends AppCompatActivity {

    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    FirebaseStorage mStorage;
    ImageButton imageButton;
    EditText edtProductName, edtDescription, edtProductPrice, edtSupplier;
    Button btnAddProduct, btnViewProducts;
    private static final int Gllery_Code = 1;
    Uri imageUrl = null;
    ProgressDialog progressDialog;

    //method to clear all user inputs
    private void clearControls(){
        edtProductName.setText("");
        edtDescription.setText("");
        edtProductPrice.setText("");
        edtSupplier.setText("");
        imageButton.setImageURI(Uri.parse(""));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        this.setTitle("Products");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageButton = findViewById(R.id.ibProductImg);
        edtProductName = findViewById(R.id.etProductName);
        edtDescription = findViewById(R.id.etDescription);
        edtProductPrice = findViewById(R.id.etProductPrice);
        edtSupplier = findViewById(R.id.etSupplier);
        btnAddProduct = findViewById(R.id.btnSubmitProduct);
        btnViewProducts = findViewById(R.id.btnAllProducts);

        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference().child("Product");
        mStorage = FirebaseStorage.getInstance();
        progressDialog = new ProgressDialog(this);

        //View all the products
        btnViewProducts.setOnClickListener(view -> {
            Intent i = new Intent(AddProduct.this, RecyclerviewProdList.class);
            startActivity(i);
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,Gllery_Code);
            }
        });
    }//end of onCreate

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == Gllery_Code && resultCode == RESULT_OK){
            imageUrl = data.getData();
            imageButton.setImageURI(imageUrl);
        }

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ProductName = edtProductName.getText().toString().trim();
                String Description = edtDescription.getText().toString().trim();
                String ProductPrice = edtProductPrice.getText().toString().trim();
                String Supplier = edtSupplier.getText().toString().trim();
                String Status = "Pending".trim();

                if(!ProductName.isEmpty() && !Description.isEmpty() && !Supplier.isEmpty() && imageUrl != null){
                    progressDialog.setTitle("Uploading...");
                    progressDialog.show();

                    StorageReference filepath = mStorage.getReference().child("ProductPost").child(imageUrl.getLastPathSegment()); //imagePost - ProductPost
                    filepath.putFile(imageUrl).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> downloadUrl = taskSnapshot.getStorage().getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    String t = task.getResult().toString();

                                    DatabaseReference newPost = mRef.push();

                                    newPost.child("ProductName").setValue(ProductName);
                                    newPost.child("Description").setValue(Description);
                                    newPost.child("ProductPrice").setValue(ProductPrice);
                                    newPost.child("Supplier").setValue(Supplier);
                                    newPost.child("Status").setValue(Status);
                                    newPost.child("image").setValue(task.getResult().toString());
                                    progressDialog.dismiss();
                                    clearControls();
                                    Toast.makeText(getApplicationContext(),"Product added successfully",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                }
            }
        });
    }
}