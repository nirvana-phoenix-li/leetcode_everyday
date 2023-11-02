package test;

import everyday.y2022.august.StockPrice;

public class T888 {
    public static void main(String[] args) {
        //"StockPrice","update","current","current","update","update","maximum","minimum"
        //],[765,3848],[],[],[765,8511],[853,6124],[],[],[765,5733]
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(765,3848);
        stockPrice.current();
        stockPrice.current();
        stockPrice.update(765,8511);
        stockPrice.update(853,6124);
        stockPrice.maximum();
        stockPrice.minimum();
    }
}
