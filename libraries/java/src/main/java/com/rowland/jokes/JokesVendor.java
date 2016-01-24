package com.rowland.jokes;

import java.util.Random;

public class JokesVendor {

    private String[] jokesArray;
    private Random random;

    public JokesVendor() {
        jokesArray = new String[10];
        jokesArray[0] = "How do functions break up? \"They stop calling each other!\"";
        jokesArray[1] = "In what unit do you measure a function's length? \"In Para meters...\"";
        jokesArray[2] = "What did the flirtatious function say? \"Call me ;)\"";
        jokesArray[3] = "Q: How do you tell an introverted computer scientist from an extroverted computer scientist?\n" +
                        "\n" +
                        "A: An extroverted computer scientist looks at your shoes when he talks to you.";
        jokesArray[4] = "A young man was walking along in the forest, when he heard a muffled voice crying for help from behind a log.  He leaned over to see a frog sitting in the mud.\n" +
                        "\n" +
                        "The frog looked up at him and said, \"I'm actually a beautiful princess, and if you kiss me, I'll transform back into my true self, and be yours for eternity.\"\n" +
                        "\n" +
                        "Silently, the man scooped up the frog and continued on his walk.\n" +
                        "\n" +
                        "A minute or two later, the frog piped up again, \"Hey, buddy, maybe you didn't hear me -- I said, if you kiss me, I'll turn into a princess. What are you waiting for?\"\n" +
                        "\n" +
                        "Annoyed, the man stuffed the frog into his coat pocket.\n" +
                        "\n" +
                        "Shocked, the frog yelled from inside the man's pocket, \"What the hell?  I'm a princess!  All you have to do is kiss me!\"\n" +
                        "\n" +
                        "Opening his pocket and peering in, the man said, \"Listen -- I'm a software engineer.  I don't have time for a girlfriend.  But a talking frog is kind of cool.\"";
        jokesArray[5] = "Programs for sale: fast, reliable, cheap - choose two";
        jokesArray[6] = "What happened to all the illegal exceptions? \"They were all caught!\"\n";
        jokesArray[7] = "When is a function a bad investment? \"When there's no return\"";
        jokesArray[8] = "If you put a million monkeys at a million keyboards, one of them will eventually write a Java program.\n" +
                        "\n" +
                        "The rest of them will write Perl programs\n";
        jokesArray[9] = "A man flying in a hot air balloon suddenly realizes he’s lost. He reduces height and spots a man down below. He lowers the balloon further and shouts to get directions, \"Excuse me, can you tell me where I am?\"\n" +
                        "\n" +
                        "The man below says: \"Yes, you're in a hot air balloon, hovering 30 feet above this field.\"\n" +
                        "\n" +
                        "\"You must work in Information Technology,\" says the balloonist.\n" +
                        "\n" +
                        "\"I do\" replies the man. \"How did you know?\"\n" +
                        "\n" +
                        "\"Well,\" says the balloonist, \"everything you have told me is technically correct, but it's of no use to anyone.\"\n" +
                        "\n" +
                        "The man below replies, \"You must work in management.\"\n" +
                        "\n" +
                        "\"I do\" replies the balloonist, \"But how'd you know?\"\n" +
                        "\n" +
                        "\"Well\", says the man, \"you don’t know where you are, or where you’re going, you expect me to be able to help. You’re in the same position you were before we met, but now it’s my fault.\"\n";
        random = new Random();
    }

    public String getRandomJoke() {
        return jokesArray[random.nextInt(jokesArray.length)];
    }

}
