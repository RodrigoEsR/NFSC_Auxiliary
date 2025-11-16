package com.nfscauxiliary.models.entities;

import java.util.*;

import com.nfscauxiliary.models.enums.InvoiceStatus;
import com.nfscauxiliary.models.entities.Client;
import com.nfscauxiliary.models.entities.ServiceProvider;
import com.nfscauxiliary.models.entities.MateriaList;
import com.nfscauxiliary.models.entities.ServiceList;

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
    private MateriaList materialList;
    private ServiceList serviceList;
    
}
