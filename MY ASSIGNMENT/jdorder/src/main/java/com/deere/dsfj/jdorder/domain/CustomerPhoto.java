package com.deere.dsfj.jdorder.domain;

import java.io.InputStream;

/** This class will hold the CustomerPhoto data*/
public class CustomerPhoto {
    
	/**instance of the customer*/
    private Customer customer = null;
    
    /**this variable will hold the input stream for customer photo*/
    private InputStream inputStream = null;
    
    private String originalFileName = null;
 
    /** for output. For displaying file or image. 
     * for ex. c:/www/DSFJOrder/virtualDoc/images/Customer00000001.jpg
     * */
    private String filePathOnServer = null;

    private long sizeInBytes = -1;

    /** getters and setters of CustomerPhoto fields*/
    public final InputStream getInputStream() {
        return inputStream;
    }

    public final void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public final String getOriginalFileName() {
        return originalFileName;
    }

    public final void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public final long getSizeInBytes() {
        return sizeInBytes;
    }

    public final void setSizeInBytes(long sizeInBytes) {
        this.sizeInBytes = sizeInBytes;
    }

    public final String getFilePathOnServer() {
        return filePathOnServer;
    }

    public final void setFilePathOnServer(String filePathOnServer) {
        this.filePathOnServer = filePathOnServer;
    }

    public final Customer getCustomer() {
        return customer;
    }

    public final void setCustomer(Customer customer) {
        this.customer = customer;
    }

   
}
