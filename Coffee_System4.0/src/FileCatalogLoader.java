import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileCatalogLoader implements CatalogLoader{
    @Override
    public Catalog loadCatalog(String fileName) throws FileNotFoundException, IOException, DataFormatException {
       Catalog catalog=new Catalog();
       BufferedReader reader=new BufferedReader(new FileReader(fileName));
       String line=reader.readLine();
       while(line!=null){
           Product product=null;
           if(line.startsWith("Product")) {
               product = readProduct(line);
           }
           else if (line.startsWith("Coffee")) {
               product=readCoffee(line);
           }else if(line.startsWith("Brewer")){
               product=readCoffeeBrewer(line);
           }
           catalog.addProduct(product);
           line=reader.readLine();
       }
       return catalog;
    }
    private Product readProduct(String line) throws DataFormatException{
        StringTokenizer tokenizer=new StringTokenizer(line,"_");
        if(tokenizer.countTokens()!=4){
            throw new DataFormatException(line);
        }
        try{
            String str=tokenizer.nextToken();
            return new Product(tokenizer.nextToken(),
                    tokenizer.nextToken(),
                    Double.parseDouble(tokenizer.nextToken()));
        }catch(NumberFormatException numberFormatException){
            throw new DataFormatException(line);
        }
    }
    private Coffee readCoffee(String line) throws DataFormatException{
        StringTokenizer tokenizer=new StringTokenizer(line,"_");
        if(tokenizer.countTokens()!=10){
            throw new DataFormatException(line);
        }
        try{
            String str=tokenizer.nextToken();
            return new Coffee(tokenizer.nextToken(),
                    tokenizer.nextToken(),
                    Double.parseDouble(tokenizer.nextToken()),
                    tokenizer.nextToken(),
                    tokenizer.nextToken(),
                    tokenizer.nextToken(),
                    tokenizer.nextToken(),
                    tokenizer.nextToken(),
                    tokenizer.nextToken());
        }catch(NumberFormatException numberFormatException){
            throw new DataFormatException(line);
        }
    }

    private CoffeeBrewer readCoffeeBrewer(String line) throws DataFormatException{
        StringTokenizer tokenizer=new StringTokenizer(line,"_");
        if(tokenizer.countTokens()!=7){
            throw new DataFormatException(line);
        }
        try{
            String str=tokenizer.nextToken();
            return new CoffeeBrewer(tokenizer.nextToken(),
                    tokenizer.nextToken(),
                    Double.parseDouble(tokenizer.nextToken()),
                    tokenizer.nextToken(),
                    tokenizer.nextToken(),
                    Integer.parseInt(tokenizer.nextToken()));
        }catch(NumberFormatException numberFormatException){
            throw new DataFormatException(line);
        }
    }


}
