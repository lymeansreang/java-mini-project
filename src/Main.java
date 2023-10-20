import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        List<Product> productList=new ArrayList<>();
        Scanner s = new Scanner(System.in);

        int currentPage = 1;
        int rowsPerPage = 2;

        productList.add(new Product(1,"iPhone 14 pro Max", 50,1500.00, LocalDate.now()) );
        productList.add(new Product(2,"iPhone 15 pro Max", 40,1600.00, LocalDate.now()) );
        productList.add(new Product(3,"Samsung Galaxy Fold", 30,1700.00, LocalDate.now()) );
        productList.add(new Product(4,"Samsung Galaxy Flip z", 20,1899.00, LocalDate.now()) );
        productList.add(new Product(5,"Ipad pro", 10,1888.00, LocalDate.now()) );
        productList.add(new Product(6,"MAC Book pro", 60,1500.00, LocalDate.now()) );
        productList.add(new Product(7,"ROG", 70,1600.00, LocalDate.now()) );
        productList.add(new Product(8,"Sony WF-1000XM5", 80,299.00, LocalDate.now()) );

        System.out.println(
                " ██████╗███████╗████████╗ █████╗ ██████╗          ██╗ █████╗ ██╗   ██╗ █████╗     \n" +
                        "██╔════╝██╔════╝╚══██╔══╝██╔══██╗██╔══██╗         ██║██╔══██╗██║   ██║██╔══██╗    \n" +
                        "██║     ███████╗   ██║   ███████║██║  ██║         ██║███████║██║   ██║███████║    \n" +
                        "██║     ╚════██║   ██║   ██╔══██║██║  ██║    ██   ██║██╔══██║╚██╗ ██╔╝██╔══██║    \n" +
                        "╚██████╗███████║   ██║   ██║  ██║██████╔╝    ╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║    \n" +
                        " ╚═════╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═════╝      ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝    \n");
        System.out.println("STOCK MANAGEMENT SYSTEM");
        do {
            Table table = new Table(9, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND);
            table.addCell(" ".repeat(4) + "| *)Display" + " ".repeat(4));
            table.addCell(" ".repeat(4) + "| W)rite" + " ".repeat(4));
            table.addCell(" ".repeat(4) + "| R)ead" + " ".repeat(4));
            table.addCell(" ".repeat(4) + "| U)pdate" + " ".repeat(4));
            table.addCell(" ".repeat(4) + "| D)elete" + " ".repeat(4));
            table.addCell(" ".repeat(4) + "| F)irst" + " ".repeat(4));
            table.addCell(" ".repeat(4) + "| P)revious" + " ".repeat(4));
            table.addCell(" ".repeat(4) + "| N)ext" + " ".repeat(4));
            table.addCell(" ".repeat(4) + "| L)ast" + " ".repeat(4));
            table.addCell(" ".repeat(4) + "| S)earch" + " ".repeat(4));
            table.addCell(" ".repeat(4) + "| G)oto" + " ".repeat(4));
            table.addCell(" ".repeat(4) + "| Se)t row" + " ".repeat(4));
            table.addCell(" ".repeat(4) + "| H)elp" + " ".repeat(4));
            table.addCell(" ".repeat(4) + "| E)xit" + " ".repeat(4));
            System.out.println(table.render());

            System.out.print("Command --> ");
            String op = s.nextLine();
            switch (op) {
                case "*" -> display(productList, currentPage, rowsPerPage);
                case "w", "W" -> write(productList);
                case "r", "R" -> read(productList);
                case "u", "U" -> update(productList);
                case "d", "D" -> delete(productList);
                case "f", "F" -> currentPage = first(currentPage, rowsPerPage, productList);
                case "p", "P" -> currentPage = previous(productList,currentPage, rowsPerPage);
                case "n", "N" -> currentPage = next(currentPage, rowsPerPage, productList);
                case "l", "L" -> currentPage = last(currentPage, rowsPerPage, productList);
                case "s", "S" -> search(productList, currentPage, rowsPerPage);
                case "g", "G" -> currentPage = goTo(currentPage, rowsPerPage, productList);
                case "se", "Se" -> rowsPerPage = setRow(rowsPerPage,productList);
                case "h", "H" -> help();
                case "e", "E" -> exit();
                default-> {
                    String[] shortCut = op.split("#");
                    switch (shortCut[0]){
                        case "r","R"->{
                            int proId = Integer.parseInt(shortCut[1]);
                            productList.forEach(product -> {
                                if(product.getProCode().equals(proId)){
                                    Table tbl = new Table(1,BorderStyle.UNICODE_BOX_DOUBLE_BORDER,ShownBorders.SURROUND);
                                    tbl.addCell(" ID            : "+proId+" ".repeat(10));
                                    tbl.addCell(" Name          : "+product.getProName()+" ".repeat(10));
                                    tbl.addCell(" Unit price    : "+product.getPrice()+" ".repeat(10));
                                    tbl.addCell(" Qty           : "+product.getQty()+" ".repeat(10));
                                    tbl.addCell(" Imported Date : "+LocalDate.now()+" ".repeat(10));
                                    System.out.println(tbl.render());
                                }
                            });
                        }
                        case "d","D"->{
                            int proId = Integer.parseInt(shortCut[1]);
                            boolean found = false;
                            for (Product product: productList){
                                if(product.getProCode().equals(proId)){
                                    Table tbl = new Table(1,BorderStyle.UNICODE_BOX_DOUBLE_BORDER,ShownBorders.SURROUND);
                                    tbl.addCell(" ID            : "+proId+" ".repeat(10));
                                    tbl.addCell(" Name          : "+product.getProName()+" ".repeat(10));
                                    tbl.addCell(" Unit price    : "+product.getPrice()+" ".repeat(10));
                                    tbl.addCell(" Qty           : "+product.getQty()+" ".repeat(10));
                                    tbl.addCell(" Imported Date : "+LocalDate.now()+" ".repeat(10));
                                    System.out.println(tbl.render());
                                    System.out.print( "Are you sure to add this record? [Y/y] or [N/n] : ");
                                    String options = s.nextLine();
                                    switch (options) {
                                        case "y","Y" -> {
                                            productList.remove(product);
                                            System.out.println("Product with ID " + proId + " deleted successfully.");
                                        }
                                        case "n","N" -> {
                                            System.out.println("Product is not deleted");
                                        }
                                        default -> throw new IllegalStateException("Unexpected value: " + shortCut[0]);
                                    }found=true;
                                    break;
                                }
                            }if(!found){
                                System.out.println("not found");
                            }
                        }
                        case "w","W"->{
                            Product lastProduct = productList.get(productList.size() - 1);
                            Integer proCode = lastProduct.getProCode()+1;
                            String[] aftshort = shortCut[1].split("-");
                            String proName = aftshort[0];
                            Double price = Double.parseDouble(aftshort[1]);
                            Integer qty = Integer.parseInt(aftshort[2]);
                            Product newPro = new Product(proCode,proName,qty,price,LocalDate.now());

                            Table tbl2 = new Table(1,BorderStyle.UNICODE_BOX_DOUBLE_BORDER,ShownBorders.SURROUND);
                            tbl2.addCell(" ID            : "+proCode+" ".repeat(10));
                            tbl2.addCell(" Name          : "+proName+" ".repeat(10));
                            tbl2.addCell(" Unit price    : "+price+" ".repeat(10));
                            tbl2.addCell(" Qty           : "+qty+" ".repeat(10));
                            tbl2.addCell(" Imported Date : "+LocalDate.now()+" ".repeat(10));
                            System.out.println(tbl2.render());
                            System.out.print( "Are you sure to add this record? [Y/y] or [N/n] : ");
                            String options = s.nextLine();
                            switch (options) {
                                case "y","Y" -> {
                                    productList.add(newPro);
                                    System.out.println("Product added successfully.");
                                }
                                case "n","N" -> {
                                    System.out.println("Product is not added");
                                }
                                default -> System.out.println("Invalid options.");
                            }
                        }

                    }
                }

            }
        }while (true);
    }
    public static void display (List<Product> productList, int currentPage, int rowsPerPage) {

        int startIndex = (currentPage - 1) * rowsPerPage;
        int endIndex = Math.min(startIndex + rowsPerPage, productList.size());

        Table table2=new Table(5,BorderStyle.UNICODE_BOX_DOUBLE_BORDER,ShownBorders.ALL);

        table2.addCell(" ".repeat(6)+"ID"+" ".repeat(6));
        table2.addCell(" ".repeat(6)+"NAME"+" ".repeat(6));
        table2.addCell(" ".repeat(6)+"UNIT PRICE"+" ".repeat(6));
        table2.addCell(" ".repeat(6)+"QTY"+" ".repeat(6));
        table2.addCell(" ".repeat(6)+"IMPORTED DATE"+" ".repeat(6));

        for (int i = startIndex;i < endIndex; i++){
            Product products = productList.get(i);
            table2.addCell(" ".repeat(6)+products.getProCode());
            table2.addCell(products.getProName()+" ".repeat(6));
            table2.addCell(" ".repeat(6)+products.getPrice().toString()+"$");
            table2.addCell(" ".repeat(6)+products.getQty().toString());
            table2.addCell(" ".repeat(6)+products.getImportDate().toString());
        }
        System.out.println(table2.render());
        Table table3 = new Table(1,BorderStyle.DESIGN_CURTAIN_WIDE,ShownBorders.SURROUND);
        int totalPages = (int) Math.ceil((double) productList.size() / rowsPerPage);
        table3.addCell("Page " + currentPage + " of " + totalPages + " ".repeat(40) + "Total records : " + productList.size());
        System.out.println(table3.render());
    }
    public static void write (List<Product> productList) {
        Scanner s = new Scanner(System.in);
        Product lastProduct = productList.get(productList.size() - 1);
        Integer proCode = lastProduct.getProCode()+1;

        try {
            System.out.println("Product ID : "+proCode);
            System.out.print("Product name : ");String name = s.nextLine();
            System.out.print("Product Price : ");Double price = Double.parseDouble(s.nextLine());
            System.out.print("Product Quantity : ");Integer qty = Integer.parseInt(s.nextLine());

            Product product = new Product(proCode, name, qty, price, LocalDate.now());
            productList.add(product);

            do {
                Table table = new Table(1,BorderStyle.UNICODE_BOX_DOUBLE_BORDER,ShownBorders.SURROUND);
                table.addCell(" ID            : "+proCode+" ".repeat(10));
                table.addCell(" Name          : "+name+" ".repeat(10));
                table.addCell(" Unit price    : "+price+" ".repeat(10));
                table.addCell(" Qty           : "+qty+" ".repeat(10));
                table.addCell(" Imported Date : "+LocalDate.now()+" ".repeat(10));
                System.out.println(table.render());
                System.out.print( "Are you sure to add this record? [Y/y] or [N/n] : ");
                String options = s.nextLine();
                switch (options) {
                    case "y","Y" -> {
                        System.out.println("Product added successfully.");
                        return;
                    }
                    case "n","N" -> {
                        productList.remove(product);
                        System.out.println("Product is not added");
                        return;
                    }
                    default -> System.out.println("Invalid options.");
                }
            }while (true);
        } catch (Exception exception) {
            System.out.print(exception.getMessage());
        }
    }
    public static void read(List<Product> productList) {
        Scanner s = new Scanner(System.in);
        boolean found = false;
        try{
            System.out.print("Read by ID : ");Integer proID = Integer.parseInt(s.nextLine());
            for (Product product : productList) {
                if (product.getProCode() == proID) {
                    Table table = new Table(1,BorderStyle.UNICODE_BOX_DOUBLE_BORDER,ShownBorders.SURROUND);
                    table.addCell(" ID            : "+proID+" ".repeat(10));
                    table.addCell(" Name          : "+product.getProName()+" ".repeat(10));
                    table.addCell(" Unit price    : "+product.getPrice()+" ".repeat(10));
                    table.addCell(" Qty           : "+product.getQty()+" ".repeat(10));
                    table.addCell(" Imported Date : "+LocalDate.now()+" ".repeat(10));
                    System.out.println(table.render());
                    found=true;
                    break;
                }
            }if(!found){
                System.out.println("Product with id "+ proID +" is not found");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void update (List<Product> productList) {
        Scanner s =new Scanner(System.in);
        boolean found=false;
        try{
            System.out.println("Enter Id to update: ");Integer toUpdateId=Integer.parseInt(s.nextLine());
            for (Product products: productList){
                if(products.getProCode().equals(toUpdateId)){
                    Table table = new Table(1,BorderStyle.UNICODE_BOX_DOUBLE_BORDER,ShownBorders.SURROUND);
                    table.addCell(" ID            : "+toUpdateId+" ".repeat(10));
                    table.addCell(" Name          : "+products.getProName()+" ".repeat(10));
                    table.addCell(" Unit price    : "+products.getPrice()+" ".repeat(10));
                    table.addCell(" Qty           : "+products.getQty()+" ".repeat(10));
                    table.addCell(" Imported Date : "+LocalDate.now()+" ".repeat(10));
                    System.out.println(table.render());
                    found=true;
                    break;
                }
            }if(!found) {
                System.out.println("Product with id " + toUpdateId + " is not found");
            }
            Product updateProduct=null;
            for(Product products: productList){
                if(products.getProCode().equals(toUpdateId)){
                    updateProduct= products;
                    found=true;
                    break;
                }
            }if(!found) {
                System.out.println("Product with id " + toUpdateId + " is not found");
            }
            Product products=updateProduct;

            System.out.println("What do you want to update?");
            Table tableUpdate = new Table(5, BorderStyle.UNICODE_ROUND_BOX, ShownBorders.SURROUND);
            tableUpdate.addCell(" ".repeat(4)+"1. All"+" ".repeat(4));
            tableUpdate.addCell(" ".repeat(4)+"2. Name"+" ".repeat(4));
            tableUpdate.addCell(" ".repeat(4)+"3. Quantity"+" ".repeat(4));
            tableUpdate.addCell(" ".repeat(4)+"4. Price"+" ".repeat(4));
            tableUpdate.addCell(" ".repeat(4)+"5. Back to menu"+" ".repeat(4));
            System.out.println(tableUpdate.render());

            try{
                System.out.println("Please choose Option (1-5): ");
                int op=Integer.parseInt(s.nextLine());
                switch (op){
                    case 1:{
                        System.out.println("Enter new product name: ");String newProName=s.nextLine();
                        System.out.println("Enter new qty: ");Integer newQty=Integer.parseInt(s.nextLine());
                        System.out.println("Enter new price");Double newPrice=Double.parseDouble(s.nextLine());

                        products.setProName(newProName);
                        products.setQty(newQty);
                        products.setPrice(newPrice);
                        Table updatedTable = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND);
                        updatedTable.addCell(" ID            : " + toUpdateId + " ".repeat(10));
                        updatedTable.addCell(" Name          : " + newProName + " ".repeat(10));
                        updatedTable.addCell(" Unit price    : " + newPrice + " ".repeat(10));
                        updatedTable.addCell(" Qty           : " + newQty + " ".repeat(10));
                        updatedTable.addCell(" Imported Date : " + LocalDate.now() + " ".repeat(10));
                        System.out.println(updatedTable.render());

                        System.out.print("Are you sure to add this record? [Y/y] or [N/n] : ");
                        String opt = s.nextLine();
                        switch (opt) {
                            case "y", "Y" : {
                                productList.add(updateProduct);
                                System.out.println("Product added successfully.");
                            }break;
                            case "n", "N" : System.out.println("Product is not added");break;
                            default : System.out.println("Invalid options.");break;
                        }
                    }break;
                    case 2:{
                        try {
                            System.out.println("Enter new product name : ");
                            String newProductName = s.nextLine();
                            products.setProName(newProductName);
                            Table updatedTable = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND);
                            updatedTable.addCell(" ID            : " + toUpdateId + " ".repeat(10));
                            updatedTable.addCell(" Name          : " + newProductName + " ".repeat(10));
                            updatedTable.addCell(" Unit price    : " + products.getPrice() + " ".repeat(10));
                            updatedTable.addCell(" Qty           : " + products.getQty() + " ".repeat(10));
                            updatedTable.addCell(" Imported Date : " + LocalDate.now() + " ".repeat(10));
                            System.out.println(updatedTable.render());
                            System.out.print( "Are you sure to add this record? [Y/y] or [N/n] : ");
                            String options = s.nextLine();
                            switch (options) {
                                case "y","Y" -> {
                                    productList.add(updateProduct);
                                    System.out.println("Product added successfully.");
                                }
                                case "n","N" -> System.out.println("Product is not added");
                                default -> System.out.println("Invalid options.");
                            }
                        } catch (Exception exception) {
                            System.out.println(exception.getMessage());
                        }
                    }break;
                    case 3:{
                        try {
                            System.out.println("Enter new product Price : ");
                            Double newProductPrice = Double.parseDouble(s.nextLine());
                            products.setPrice(newProductPrice);
                            Table updatedTable = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND);
                            updatedTable.addCell(" ID            : " + toUpdateId + " ".repeat(10));
                            updatedTable.addCell(" Name          : " + products.getProName() + " ".repeat(10));
                            updatedTable.addCell(" Unit price    : " + newProductPrice + " ".repeat(10));
                            updatedTable.addCell(" Qty           : " + products.getQty() + " ".repeat(10));
                            updatedTable.addCell(" Imported Date : " + LocalDate.now() + " ".repeat(10));
                            System.out.println(updatedTable.render());
                            System.out.print( "Are you sure to add this record? [Y/y] or [N/n] : ");
                            String options = s.nextLine();
                            switch (options) {
                                case "y","Y" -> {
                                    productList.add(updateProduct);
                                    System.out.println("Product added successfully.");
                                }
                                case "n","N" -> System.out.println("Product is not added");
                                default -> System.out.println("Invalid options.");
                            }
                        } catch (Exception exception) {
                            System.out.println(exception.getMessage());
                        }
                    }break;
                    case 4:{
                        try {
                            System.out.println("Enter new product Price : ");
                            Integer newProductQty = Integer.parseInt(s.nextLine());
                            products.setQty(newProductQty);
                            Table updatedTable = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND);
                            updatedTable.addCell(" ID            : " + toUpdateId + " ".repeat(10));
                            updatedTable.addCell(" Name          : " + products.getProName() + " ".repeat(10));
                            updatedTable.addCell(" Unit price    : " + products.getPrice() + " ".repeat(10));
                            updatedTable.addCell(" Qty           : " + newProductQty + " ".repeat(10));
                            updatedTable.addCell(" Imported Date : " + LocalDate.now() + " ".repeat(10));
                            System.out.println(updatedTable.render());
                            System.out.print( "Are you sure to add this record? [Y/y] or [N/n] : ");
                            String options = s.nextLine();
                            switch (options) {
                                case "y","Y" -> {
                                    productList.add(updateProduct);
                                    System.out.println("Product added successfully.");
                                }
                                case "n","N" -> System.out.println("Product is not added");
                                default -> System.out.println("Invalid options.");
                            }
                        } catch ( Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }break;
                    case 5:{
                        System.out.println("Back to menu");
                    }break;
                    default:throw new IllegalStateException("Unexpected value: "+ op);
                }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public static  void delete (List<Product> productList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Product id to delete: ");Integer productId = Integer.parseInt(scanner.nextLine());

        for (Product products : productList) {
            if (products.getProCode().equals(productId)) {
                Table table = new Table(1,BorderStyle.UNICODE_BOX_DOUBLE_BORDER,ShownBorders.SURROUND);
                table.addCell(" ID            : "+products.getProCode()+" ".repeat(10));
                table.addCell(" Name          : "+products.getProName()+" ".repeat(10));
                table.addCell(" Unit price    : "+products.getPrice()+" ".repeat(10));
                table.addCell(" Qty           : "+products.getQty()+" ".repeat(10));
                table.addCell(" Imported Date : "+LocalDate.now()+" ".repeat(10));
                System.out.println(table.render());
                System.out.print( "Are you sure to add this record? [Y/y] or [N/n] : ");
                String options = scanner.nextLine();
                switch (options) {
                    case "y","Y" -> {
                        productList.remove(products);
                        System.out.println("Product with ID " + productId + " deleted successfully.");
                        return;
                    }
                    case "n","N" -> {
                        System.out.println("Product is not deleted");
                        return;
                    }
                    default -> System.out.println("Invalid options.");
                }
            }
        }
        System.out.println("Product with ID " + productId + " not found.");
    }
    public static int first (int currentPage, int rowsPerPage, List<Product> productList) {
        if (currentPage == 1) {
            System.out.println("You are already on the first page.");
        } else {
            currentPage = 1;
            display(productList, currentPage, rowsPerPage);
        }
        return currentPage;
    }
    public static int previous (List<Product> productList, int currentPage, int rowsPerPage) {
        if (currentPage > 1) {
            currentPage--;
            display(productList, currentPage, rowsPerPage);
        } else {
            System.out.println("You are already on the first page.");
        }
        return currentPage;
    }
    public static int next(int currentPage, int rowsPerPage, List<Product> productList) {
        int totalPages = (int) Math.ceil((double) productList.size() / rowsPerPage);
        if (currentPage < totalPages) {
            currentPage++;
        } else {
            currentPage = 1;
        }
        display(productList, currentPage, rowsPerPage);
        return currentPage;
    }
    public static int last(int currentPage, int rowsPerPage, List<Product> productList) {
        int totalPages = (int) Math.ceil((double) productList.size() / rowsPerPage);
        if (currentPage == totalPages) {
            System.out.println("You are already on the last page.");
        } else {
            currentPage = totalPages;
            display(productList, currentPage, rowsPerPage);
        }
        return currentPage;
    }
    public static void search (List<Product> productList, int currentPage, int rowsPerPage) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Search product by keyword: ");
        String searchKeyword = scanner.nextLine().toLowerCase();

        List<Product> matchingProducts = new ArrayList<>();

        for (Product product : productList) {
            String productName = product.getProName().toLowerCase();

            if (productName.contains(searchKeyword)) {
                matchingProducts.add(product);
            }
        }

        int totalPages = (int) Math.ceil((double) matchingProducts.size() / rowsPerPage);
        if (matchingProducts.isEmpty()) {
            System.out.println("No products found containing the keyword '" + searchKeyword + "'.");
        } else {
            if (currentPage < 1) {
                currentPage = 1;
            } else if (currentPage > totalPages) {
                currentPage = totalPages;
            }

            int startIndex = (currentPage - 1) * rowsPerPage;
            int endIndex = Math.min(startIndex + rowsPerPage, matchingProducts.size());

            Table tableDisplay = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER);
            tableDisplay.addCell(" ".repeat(2) + "ID" + " ".repeat(2));
            tableDisplay.addCell(" ".repeat(2) + "Name" + " ".repeat(2));
            tableDisplay.addCell(" ".repeat(2) + "Unit Price" + " ".repeat(2));
            tableDisplay.addCell(" ".repeat(2) + "Qty" + " ".repeat(2));
            tableDisplay.addCell(" ".repeat(2) + "Imported Date" + " ".repeat(2));

            for (int i = startIndex; i < endIndex; i++) {
                Product product = matchingProducts.get(i);
                tableDisplay.addCell(" ".repeat(2) + product.getProCode().toString());
                tableDisplay.addCell(" ".repeat(2) + product.getProName());
                tableDisplay.addCell(" ".repeat(2) + product.getPrice().toString());
                tableDisplay.addCell(" ".repeat(2) + product.getQty().toString());
                tableDisplay.addCell(" ".repeat(2) + product.getImportDate().toString());
            }

            System.out.println(tableDisplay.render());
            Table table3 = new Table(1,BorderStyle.DESIGN_CURTAIN_WIDE,ShownBorders.SURROUND);
            table3.addCell("Page " + currentPage + " of " + totalPages + " ".repeat(40) + "Total records : " + productList.size());
            System.out.println(table3.render());
        }
    }
    public static int goTo(int currentPage, int rowsPerPage, List<Product> productList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the page number you want to go to: ");int targetPage = scanner.nextInt();
        int totalPages = (int) Math.ceil((double) productList.size() / rowsPerPage);
        if (targetPage >= 1 && targetPage <= totalPages) {
            currentPage = targetPage;
            display(productList, currentPage, rowsPerPage);
        } else {
            System.out.println("Invalid page number. Please enter a page number between 1 and " + totalPages + ".");
        }
        return currentPage;
    }
    public static int setRow( int rowsPerPage, List<Product> productList) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter number of row(s) you want to display : ");
            int numberOfRows = Integer.parseInt(sc.nextLine());
            if (numberOfRows >0 && numberOfRows <= productList.size()){
                return numberOfRows;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rowsPerPage;
    }
    public static void help () {
        Table table1 = new Table(1, BorderStyle.CLASSIC_COMPATIBLE_LIGHT_WIDE, ShownBorders.SURROUND);
        table1.addCell("1.  Press     * : Display all record of products");
        table1.addCell("2.  Press     w : Add new products");
        table1.addCell("    Press     w ->#proname-unitprice-qty : shortcut for add new product");
        table1.addCell("3.  Press     r : read Content any content");
        table1.addCell("    Press     r#proID : shortcut for read product by Id");
        table1.addCell("4.  Press     u : Update Data");
        table1.addCell("5.  Press     d : Delete Data");
        table1.addCell("    Press     u#proId : shortcut for delete product by Id");
        table1.addCell("6.  Press     f : Display First page");
        table1.addCell("7.  Press     p : Display Previous page");
        table1.addCell("8.  Press     n : Display Next page");
        table1.addCell("9.  Press     l : Display Last page");
        table1.addCell("10. Press     s : Search product by name");
        table1.addCell("11. Press     h : Help");
        table1.addCell("12. Press     e : Exit");
        System.out.println(table1.render());
    }
    public static void exit () {
        System.exit(0);
    }
}
