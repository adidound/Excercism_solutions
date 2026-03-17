public class CarsAssemble {
    
    public double productionRatePerHour(int speed) {
        int baseprod = speed*221;
        if(speed>=1 && speed<=4){
            return baseprod;
        } else if(speed>=5 && speed<=8) {
            return baseprod*0.9;    
        } else if(speed==9) {
            return baseprod*0.8;
        } else {
            return baseprod*0.77;
        }
    }

    public int workingItemsPerMinute(int speed) {
        double itemspermin= productionRatePerHour(speed)/60;
        return (int)itemspermin; 
    }
}
