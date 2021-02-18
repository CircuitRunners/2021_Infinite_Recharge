package frc.robot;


public class Indexer {
    public static void setIndexer(boolean buttonPressed){
        if(buttonPressed){
            Motors.indexerDrive.set(0.3);
        } else {
            Motors.indexerDrive.set(0.0);
        }
    }
}