package pl.umg.paw.gamestorepaw.model;

public enum Platform {
    PLAYSTATION5("PlayStation 5"),
    PLAYSTATION4("PlayStation 4"),
    PLAYSTATION3("PlayStation 3"),
    XBOX360("Xbox 360"),
    XBOXONE("Xbox One"),
    XBOXSERIESX("Xbox Series X");

    private String platformName;

    Platform(String platformName) {
        this.platformName = platformName;
    }

    @Override
    public String toString() {
        return platformName;
    }
}
