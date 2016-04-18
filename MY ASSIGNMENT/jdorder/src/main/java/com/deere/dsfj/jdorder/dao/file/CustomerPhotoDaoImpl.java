package com.deere.dsfj.jdorder.dao.file;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Repository;

import com.deere.dsfj.jdorder.config.ApplicationProperties;
import com.deere.dsfj.jdorder.dao.CustomerPhotoDao;
import com.deere.dsfj.jdorder.domain.Customer;
import com.deere.dsfj.jdorder.domain.CustomerPhoto;
import com.deere.dsfj.utility.StringUtils;

/** This class is used to */
@Repository(value="customerPhotoDao")
public class CustomerPhotoDaoImpl implements CustomerPhotoDao{

	/**This method is used to save the photo into directory*/
    public void add(CustomerPhoto customerPhoto) {
        update(customerPhoto);
    }

    /**This method is used to delete the photo from directory*/
    public void delete(CustomerPhoto customerPhoto) {
    	//get the photo file name
        String photoFileName = getPhotoFileName(customerPhoto.getCustomer());
        
        //get the directory path where photos are stored
        String imagePath = ApplicationProperties.getInstance().getCustomerProperties().getString("customerPhotoImagesPath");
        
        //build the final path
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append(imagePath);
        strBuffer.append("/");
        strBuffer.append(photoFileName);
        
        //this is the actual path to a photo file on a server
        String finalPath = strBuffer.toString();
        File finalFile = new File(finalPath);
        boolean oldFileExisted = finalFile.exists();
        
        //check if photo exists, if yes then delete the photo
        if (oldFileExisted) {
            finalFile.delete();
        }
    }

    /**This method reads the photo from directory.The path of the file on server  */
    public CustomerPhoto getCustomerPhoto(Customer customer) {
        CustomerPhoto customerPhoto = null;

        //get the photo file name
        String photoFileName = getPhotoFileName(customer);
        
        //get the directory path where photos are stored
        String imagePath = ApplicationProperties.getInstance().getCustomerProperties().getString("customerPhotoImagesPath");

        //build the final path
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append(imagePath);
        strBuffer.append("/");
        strBuffer.append(photoFileName);

        //this is the actual path to a photo file on a server
        String finalPath = strBuffer.toString();
        File finalFile = new File(finalPath);
        boolean fileExists = finalFile.exists();
        
        //check if photo exists, if yes then create Customer Photo object
        if(fileExists){
            customerPhoto = new CustomerPhoto();
            customerPhoto.setCustomer(customer);
            customerPhoto.setFilePathOnServer(finalPath);
        }
        return customerPhoto;
    }

    /** This method is used to save/update the photo in a directory*/
    public void update(CustomerPhoto customerPhoto) {

        //get the photo file name
        String photoFileName = getPhotoFileName(customerPhoto.getCustomer());

        //get the directory path where photos are stored
        String imagePath = ApplicationProperties.getInstance().getCustomerProperties().getString("customerPhotoImagesPath");
        
        //build the final path
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append(imagePath);
        strBuffer.append("/");
        strBuffer.append(photoFileName);
        
        //this is the actual path to a photo file on a server
        String finalPath = strBuffer.toString();
        
        File finalFile = new File(finalPath);
        boolean oldFileExisted = finalFile.exists();
        //check whether photo exists. if yes then delete it
        if (oldFileExisted) {
            finalFile.delete();
        }

        InputStream inputStream = null;
        OutputStream outputStream = null;
        try{
        	//save the photo in directory
            inputStream = customerPhoto.getInputStream();
            if(inputStream != null){
                outputStream = FileUtils.openOutputStream(finalFile);
                IOUtils.copyLarge(inputStream, outputStream);
            }
            
        }catch(IOException ioException){
            //throw ioException;
        }finally{
            if(inputStream != null){
                IOUtils.closeQuietly(inputStream);
            }
            if(outputStream != null){
                IOUtils.closeQuietly(outputStream);
            }
            
        }
    }
    
    
    /**This method returns photo file name for ex.Customer00000001.jpg*/
    public String getPhotoFileName(Customer customer) {
        StringBuffer sb = new StringBuffer("");
        String customerPrefix = ApplicationProperties.getInstance().getCustomerProperties().getString("customerPhotoFilePrefix");
        sb.append(customerPrefix);
        sb.append(StringUtils.stringWithLeadingZeros(customer.getNumber().toString(), 8));
        sb.append(".jpg");
        return sb.toString();
    }

    /**This method reads the photo file from path mentioned  */
    public CustomerPhoto getCustomerPhoto(String pathOnServer) {
        CustomerPhoto customerPhoto = null;
        File finalFile = new File(pathOnServer);
        boolean fileExists = finalFile.exists();
        InputStream input = null;
        if(fileExists)
        {
            try{
                input = FileUtils.openInputStream(finalFile);
            }catch(Exception ex){}
            customerPhoto = new CustomerPhoto();
            customerPhoto.setInputStream(input);
        }
        return customerPhoto;
    }
    
    
    

    
}
