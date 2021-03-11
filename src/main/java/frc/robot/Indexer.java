package frc.robot;


public class Indexer {

    /**
     * Sets the indexer to move balls forward on a button press.
     * @param buttonPressed Whether the button (Y) to intake is pressed
     */
    public static void setIndexer(boolean buttonPressed){

        if(buttonPressed){

            Motors.indexerDrive.set(0.3);

        } else {

            Motors.indexerDrive.set(0.0);
            
        }
    }
}