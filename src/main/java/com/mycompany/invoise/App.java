package com.mycompany.invoise;

import com.mycompany.invoise.controller.InvoiceControllerInterface;
import com.mycompany.invoise.controller.InvoiceControllerKeyBoard;
import com.mycompany.invoise.controller.InvoiceControllerDouchette;
import com.mycompany.invoise.controller.InvoiceControllerWeb;
import com.mycompany.invoise.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.repository.InvoiceRepositoryMemory;
import com.mycompany.invoise.repository.InvoiceRepositoryDatabase;
import com.mycompany.invoise.service.InvoiceServiceInterface;
import com.mycompany.invoise.service.InvoiceServiceNumber;
import com.mycompany.invoise.service.InvoiceServicePrefix;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {



        /*    Scanner sc = new Scanner(System.in);

        System.out.println("What is type the name of class controller ?");
        String controllerClass =  sc.nextLine();

        System.out.println("What is the name of the service?");
        String serviceClass =  sc.nextLine();

        System.out.println("What is the name of repository class?");
        String repositoryClass =  sc.nextLine();

        InvoiceControllerInterface invoiceController = null;


        InvoiceServiceInterface invoiceService =  null ;

        InvoiceRepositoryInterface invoiceRepository =  null ;
        try{
            invoiceController =(InvoiceControllerInterface) Class.forName(controllerClass).getDeclaredConstructor().newInstance();
            invoiceService =(InvoiceServiceInterface) Class.forName(serviceClass).getDeclaredConstructor().newInstance();
            invoiceRepository =(InvoiceRepositoryInterface) Class.forName(repositoryClass).getDeclaredConstructor().newInstance();

        }catch (Exception ex){
            ex.printStackTrace();
        }

        invoiceController.setInvoiceServiceInterface(invoiceService);
        invoiceService.setInvoiceRepositoryInterface(invoiceRepository);
*/

        ApplicationContext context =   new ClassPathXmlApplicationContext("applicationContext.xml");
        InvoiceControllerInterface invoiceController =  context.getBean(InvoiceControllerInterface.class);

        invoiceController.createInvoice();

     /*   if (configuration == 1) {

            InvoiceControllerKeyBoard invoiceControllerKeyBoard = new InvoiceControllerKeyBoard();

            //injection de dépendance
            InvoiceServiceNumber invoiceServiceNumber = new InvoiceServiceNumber();
            invoiceControllerKeyBoard.setInvoiceServiceInterface(invoiceServiceNumber);

            InvoiceRepositoryMemory invoiceRepositoryMemory = new InvoiceRepositoryMemory();
            invoiceServiceNumber.setInvoiceRepositoryInterface(invoiceRepositoryMemory);
            //--end

            invoiceControllerKeyBoard.createInvoice();

        } else if (configuration == 2) {
            InvoiceControllerWeb invoiceControllerWeb = new InvoiceControllerWeb();

            //injection de dépendance
            InvoiceServicePrefix invoiceServicePrefix = new InvoiceServicePrefix();
            invoiceControllerWeb.setInvoiceServiceInterface(invoiceServicePrefix);
            InvoiceRepositoryDatabase invoiceRepositoryDatabase = new InvoiceRepositoryDatabase();
            invoiceServicePrefix.setInvoiceRepositoryInterface(invoiceRepositoryDatabase);
            //--end

            invoiceControllerWeb.createInvoice();

        } else if (configuration == 3) {
            InvoiceControllerWeb invoiceControllerWeb = new InvoiceControllerWeb();

            //injection de dépendance
            InvoiceServiceNumber invoiceServiceNumber = new InvoiceServiceNumber();
            invoiceControllerWeb.setInvoiceServiceInterface(invoiceServiceNumber);
            InvoiceRepositoryDatabase invoiceRepositoryDatabase = new InvoiceRepositoryDatabase();
            invoiceServiceNumber.setInvoiceRepositoryInterface(invoiceRepositoryDatabase);
            //--end

            invoiceControllerWeb.createInvoice();

        } else if (configuration == 4) {
            InvoiceControllerDouchette invoiceControllerDouchette = new InvoiceControllerDouchette();

            //injection de dépendance
            InvoiceServiceNumber invoiceServiceNumber = new InvoiceServiceNumber();
            invoiceControllerDouchette.setInvoiceServiceInterface(invoiceServiceNumber);
            InvoiceRepositoryDatabase invoiceRepositoryDatabase = new InvoiceRepositoryDatabase();
            invoiceServiceNumber.setInvoiceRepositoryInterface(invoiceRepositoryDatabase);
            //--end

            invoiceControllerDouchette.createInvoice();


        }*/
    }
}
