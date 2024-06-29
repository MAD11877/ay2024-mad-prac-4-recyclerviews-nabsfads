package sg.edu.np.mad.madpractical4;

public class User {
    private final String name;
    private final String description;
    private final boolean followed;

    public User(String name, String description, boolean followed) {
        this.name = name;
        this.description = description;
        this.followed = followed;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isFollowed() {
        return followed;
    }
}
