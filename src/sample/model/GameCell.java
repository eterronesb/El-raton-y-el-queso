package sample.model;

public abstract class GameCell {
    private boolean isDiscovered;
    protected String content;

    public GameCell(String content) {
        this.content = content;
        this.isDiscovered = false;
    }

    public boolean isDiscovered() {
        return isDiscovered;
    }

    public void setDiscovered() {
        isDiscovered = true;
    }

    @Override
    public String toString() {
        return content;
    }
}
