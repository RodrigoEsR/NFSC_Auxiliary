package models.entities;

import java.util.*;

import models.enums.InvoiceStatus;

public class Invoice {
    private Integer idInvoice;
    private Date issueDate;
    private String operationType;
    private String pdfLink;
    private Integer acessKey;
    private Integer invoiceNumber;
    private String invoiceModel;
    private String serviceDescription;

    private InvoiceStatus status;
    private Client client;
    private ServiceProvider serviceProvider;
    private MateriaList materiaList;
    private ServiceList serviceList;
    
}
