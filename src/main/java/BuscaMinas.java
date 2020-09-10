import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class ManageDemand {
    static final Logger logger = Logger.getLogger(ManageDemand.class.getName());
    public long filledOrders(List<Long> orders, long k){
        int contador;
        contador = 0;
        Collections.sort(orders);
        for (int i = 0; i < orders.size(); ++i) {
            if((k-orders.get(i))>0){
                k=k-orders.get(i);
                contador++;
            }
            else{
                logger.info(String.valueOf(contador));
                return contador;
            }
        }
        return 0;
    }

}
