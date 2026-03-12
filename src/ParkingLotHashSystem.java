import java.util.Arrays;

public class ParkingLotHashSystem {

    String[] table;
    int size;

    public ParkingLotHashSystem(int size){
        this.size = size;
        table = new String[size];
    }

    private int hash(String plate){
        return Math.abs(plate.hashCode()) % size;
    }

    public int parkVehicle(String plate){

        int index = hash(plate);

        for(int i=0;i<size;i++){
            int newIndex = (index + i) % size;

            if(table[newIndex]==null){
                table[newIndex] = plate;
                return newIndex;
            }
        }

        return -1;
    }

    public void exitVehicle(String plate){

        for(int i=0;i<size;i++){
            if(plate.equals(table[i])){
                table[i] = null;
                return;
            }
        }
    }

    public void showParking(){
        System.out.println(Arrays.toString(table));
    }

    public static void main(String[] args){

        ParkingLotHashSystem parking = new ParkingLotHashSystem(10);

        System.out.println("Spot: "+parking.parkVehicle("ABC123"));
        System.out.println("Spot: "+parking.parkVehicle("XYZ999"));

        parking.showParking();
    }
}