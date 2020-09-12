import org.testng.annotations.Test;
import org.testng.Assert;

public class BuscaMinasTest {

    private static final int MINE = -1;
    private static final int SQUARE = 0;
    private static final int OPEN_SQUARE = 2;

    int [][] boardTest1 ={{MINE, SQUARE, OPEN_SQUARE},
                            {MINE, MINE, SQUARE},
                            {OPEN_SQUARE, SQUARE, MINE}};

    @Test
    public void testSelectSpaceMINE(){
        Assert.assertTrue(BuscaMinas.select_space(1, 1, boardTest1));
        Assert.assertTrue(BuscaMinas.select_space(2, 1, boardTest1));
        Assert.assertTrue(BuscaMinas.select_space(2, 2, boardTest1));
    }
    @Test
    public void testSelectSpaceSquare(){
        Assert.assertFalse(BuscaMinas.select_space(1, 2, boardTest1));
        Assert.assertEquals(boardTest1[1][2], OPEN_SQUARE);
        Assert.assertFalse(BuscaMinas.select_space(2, 3, boardTest1));
        Assert.assertEquals(boardTest1[2][3], OPEN_SQUARE);
        Assert.assertFalse(BuscaMinas.select_space(3, 2, boardTest1));
        Assert.assertEquals(boardTest1[3][2], OPEN_SQUARE);
    }
    @Test
    public void testSelectSpaceOPEN_SQUARE(){
        Assert.assertFalse(BuscaMinas.select_space(1, 3, boardTest1));
        Assert.assertEquals(boardTest1[1][3], OPEN_SQUARE);
        Assert.assertFalse(BuscaMinas.select_space(3, 1, boardTest1));
        Assert.assertEquals(boardTest1[3][1], OPEN_SQUARE);
    }
    int [][] boardTest2 ={{SQUARE, MINE, SQUARE,MINE},
            {OPEN_SQUARE,MINE,SQUARE,SQUARE},
            {OPEN_SQUARE, SQUARE, MINE, SQUARE},
            {SQUARE, MINE, MINE, OPEN_SQUARE}};
    @Test
    public void testSelectSpaceGAME(){
        Assert.assertFalse(BuscaMinas.select_space(1, 1, boardTest2));
        Assert.assertEquals(boardTest2[1][1], OPEN_SQUARE);

        Assert.assertFalse(BuscaMinas.select_space(1, 1, boardTest1));
        Assert.assertEquals(boardTest2[1][1], OPEN_SQUARE);

        Assert.assertTrue(BuscaMinas.select_space(1,2,boardTest2));

        Assert.assertFalse(BuscaMinas.select_space(1, 3, boardTest2));
        Assert.assertEquals(boardTest2[1][3], OPEN_SQUARE);

        Assert.assertFalse(BuscaMinas.select_space(2, 1, boardTest2));
        Assert.assertEquals(boardTest2[2][1], OPEN_SQUARE);

        Assert.assertFalse(BuscaMinas.select_space(2, 1, boardTest2));
        Assert.assertEquals(boardTest2[2][1], OPEN_SQUARE);

        Assert.assertFalse(BuscaMinas.select_space(2, 3, boardTest2));
        Assert.assertEquals(boardTest2[2][3], OPEN_SQUARE);

        Assert.assertFalse(BuscaMinas.select_space(2, 3, boardTest2));
        Assert.assertEquals(boardTest2[2][3], OPEN_SQUARE);

        Assert.assertFalse(BuscaMinas.select_space(3, 2, boardTest2));
        Assert.assertEquals(boardTest2[3][2], OPEN_SQUARE);

        Assert.assertFalse(BuscaMinas.select_space(2, 3, boardTest2));
        Assert.assertEquals(boardTest2[2][3], OPEN_SQUARE);

        Assert.assertTrue(BuscaMinas.select_space(4,2,boardTest2));

        Assert.assertFalse(BuscaMinas.select_space(4, 4, boardTest2));
        Assert.assertEquals(boardTest2[0][1], OPEN_SQUARE);

    }
}