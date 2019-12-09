public class ThrowData {
    public int result;
    public Pawn preview;

    public ThrowData(int r){
        result = r;
        preview = new Pawn();
        preview.setEnabled(false);
        preview.setVisible(false);
    }
}
