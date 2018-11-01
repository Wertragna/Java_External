package соm.Task1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import соm.Task1.Enums.Color;
import соm.Task1.Enums.PreciousStoneName;
import соm.Task1.Enums.SemiPreciousStoneName;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.equalTo;

public class StoneForNecklaceTest {
    StoneForNecklace stoneForNecklace;

    @Before
    public void setUp()  {
        stoneForNecklace = new StoneForNecklace();
        fillStoneForNecklace(stoneForNecklace);
    }

    @After
    public void tearDown()  {
        stoneForNecklace= null;
    }

    @Test
    public void priceStones_correctList_1251000() {
        assertEquals(new BigDecimal(1251000),stoneForNecklace.priceStones());
    }

    @Test
    public void sortByPrice_unsorted_sorted() {
        ArrayList<Stone> expected = new ArrayList<>();
        expected.add(new SemiPreciousStone
                .SemiPreciousStoneBuilder(SemiPreciousStoneName.Jasper)
                .carat(5)
                .color(Color.Red)
                .diaphaneity(Diaphaneity.Opaque)
                .price(new BigDecimal(1000))
                .build());
        expected.add(new PreciousStone
                .PreciousStoneBuilder(PreciousStoneName.Ruby)
                .carat(5)
                .color(Color.Red)
                .diaphaneity(Diaphaneity.Translucent)
                .price(new BigDecimal(50000))
                .build());
        expected.add(new PreciousStone
                .PreciousStoneBuilder(PreciousStoneName.Diamond)
                .carat(2)
                .color(Color.White)
                .diaphaneity(Diaphaneity.Transparent)
                .price(new BigDecimal(100000))
                .build());

        expected.add(new PreciousStone
                .PreciousStoneBuilder(PreciousStoneName.Diamond)
                .carat(2)
                .color(Color.White)
                .diaphaneity(Diaphaneity.Transparent)
                .price(new BigDecimal(100000))
                .build());
        expected.add(new PreciousStone
                .PreciousStoneBuilder(PreciousStoneName.Diamond)
                .carat(6)
                .color(Color.White)
                .price(new BigDecimal(1000000))
                .diaphaneity(Diaphaneity.Transparent)
                .build());
        stoneForNecklace.sortByPrice();
        assertThat(stoneForNecklace.getStones(), equalTo(expected));
    }

    @Test
    public void filterByDiapheneity_Opaque_filteredList() {
        ArrayList<Stone> expected = new ArrayList<>();
        expected.add(new SemiPreciousStone
                .SemiPreciousStoneBuilder(SemiPreciousStoneName.Jasper)
                .carat(5)
                .color(Color.Red)
                .diaphaneity(Diaphaneity.Opaque)
                .price(new BigDecimal(1000))
                .build());
        assertThat(stoneForNecklace.filterByDiapheneity(Diaphaneity.Opaque),equalTo(expected));
    }

    void fillStoneForNecklace(StoneForNecklace stoneForNecklace){
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

    }

    @Test
    public void clean_fillList_empty() {
        stoneForNecklace.cleanStone();
        assertTrue(stoneForNecklace.getStones().isEmpty());
    }
}