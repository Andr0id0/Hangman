public enum HangmanAsciiPicture {
    PICTURE0("""
                   ________
                   |/     |
                   |
                   |
                   |
                   |
                   |
                   |
                   |
                   ___________
                   |         |
            """),
    PICTURE1("""
                   ________
                   |/     |
                   |     (_)
                   |
                   |
                   |
                   |
                   |
                   |
                   ___________
                   |         |
            """),
    PICTURE2("""
                   ________
                   |/     |
                   |     (_)
                   |     _|_
                   |    /
                   |
                   |
                   |
                   |
                   ___________
                   |         |
            """),
    PICTURE3("""
                   ________
                   |/     |
                   |     (_)
                   |     _|_
                   |    / | \\
                   |
                   |
                   |
                   |
                   ___________
                   |         |
            """),
    PICTURE4("""
                   ________
                   |/     |
                   |     (_)
                   |     _|_
                   |    / | \\
                   |      |
                   |
                   |
                   |
                   ___________
                   |         |
            """),
    PICTURE5("""
                   ________
                   |/     |
                   |     (_)
                   |     _|_
                   |    / | \\
                   |      |
                   |     /
                   |    /
                   |
                   ___________
                   |         |
            """),
    PICTURE6("""
                   ________
                   |/     |
                   |     (_)
                   |     _|_
                   |    / | \\
                   |      |
                   |     / \\
                   |    /   \\
                   |
                   ___________
                   |         |
            """);

    public final String asciiPicture;

    HangmanAsciiPicture(String asciiPicture) {
        this.asciiPicture = asciiPicture;
    }
}