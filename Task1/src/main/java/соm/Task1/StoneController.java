package соm.Task1;

import соm.Task1.Enums.Color;
import соm.Task1.Enums.PreciousStoneName;
import соm.Task1.Enums.SemiPreciousStoneName;

import java.math.BigDecimal;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StoneController {
    private Scanner scanner;
    StoneForNecklace stoneForNecklace;
    final static Logger  logger = LogManager.getLogger(StoneController.class);
    public StoneController(){
        scanner = new Scanner(System.in);
        stoneForNecklace= new StoneForNecklace();
        fillStoneForNecklace(stoneForNecklace);
    }
    public void showMenu(){
        showMessage("Show stones for Nested");
        showMessage(stoneForNecklace.getStones().toString());
        showMessage("Sorted stone by price");
        stoneForNecklace.sortByPrice();
        showMessage(stoneForNecklace.getStones().toString());
        showMessage("Total stones of necklace");
        showMessage(stoneForNecklace.priceStones().toString());
        showMessage("Find stones by diaphaneity");
        Diaphaneity diaphaneity = getDiaphaneityFromConsole();
        showMessage(stoneForNecklace.filterByDiapheneity(diaphaneity).toString());
    }
    private Diaphaneity getDiaphaneityFromConsole(){
        while (true){
            try{
                showMessage("Choose diaphaneity");
                showMessage("1"+Diaphaneity.Transparent.name());
                showMessage("2"+Diaphaneity.Translucent.name());
                showMessage("3"+Diaphaneity.Opaque.name());
                int diaph= scanner.nextInt();
                switch(diaph){
                    case(1):
                        return Diaphaneity.Transparent;
                    case(2):
                        return Diaphaneity.Translucent;
                    case(3):
                        return Diaphaneity.Transparent;
                    default:
                            throw new WrongInputData();
                }
            } catch (RuntimeException e){
                logger.error(e.getMessage());
            }
        }

    }

    private void showMessage(String massege){
        System.out.println(massege);
    }

    void fillStoneForNecklace(StoneForNecklace stoneForNecklace){
        stoneForNecklace.addStone(new PreciousStone
                .PreciousStoneBuilder(PreciousStoneName.Diamond)
                .carat(6)
                .color(Color.White)
                .price(new BigDecimal(1000000))
                .diaphaneity(Diaphaneity.Transparent)
                .build());
        stoneForNecklace.addStone(new PreciousStone
                .PreciousStoneBuilder(PreciousStoneName.Diamond)
                .carat(2)
                .color(Color.White)
                .diaphaneity(Diaphaneity.Transparent)
                .price(new BigDecimal(100000))
                .build());
        stoneForNecklace.addStone(new PreciousStone
                .PreciousStoneBuilder(PreciousStoneName.Diamond)
                .carat(2)
                .color(Color.White)
                .diaphaneity(Diaphaneity.Transparent)
                .price(new BigDecimal(100000))
                .build());
        stoneForNecklace.addStone(new PreciousStone
                .PreciousStoneBuilder(PreciousStoneName.Ruby)
                .carat(5)
                .color(Color.Red)
                .diaphaneity(Diaphaneity.Translucent)
                .price(new BigDecimal(50000))
                .build());
        stoneForNecklace.addStone(new SemiPreciousStone
                .SemiPreciousStoneBuilder(SemiPreciousStoneName.Jasper)
                .carat(5)
                .color(Color.Red)
                .diaphaneity(Diaphaneity.Opaque)
                .price(new BigDecimal(1000))
                .build());
    }
}
