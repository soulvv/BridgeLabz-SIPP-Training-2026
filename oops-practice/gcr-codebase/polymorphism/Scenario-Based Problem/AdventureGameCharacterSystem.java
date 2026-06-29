class GameCharacter {
    protected String characterName;

    public GameCharacter(String characterName) {
        this.characterName = characterName;
    }

    public void performAttack() {
        System.out.println(characterName + " performs a basic attack!");
    }
}

class Warrior extends GameCharacter {
    public Warrior(String characterName) {
        super(characterName);
    }

    @Override
    public void performAttack() {
        System.out.println("Warrior " + characterName + " swings a heavy sword for physical damage!");
    }
}

class Mage extends GameCharacter {
    public Mage(String characterName) {
        super(characterName);
    }

    @Override
    public void performAttack() {
        System.out.println("Mage " + characterName + " casts a fiery fireball for magical damage!");
    }
}

class Archer extends GameCharacter {
    public Archer(String characterName) {
        super(characterName);
    }

    @Override
    public void performAttack() {
        System.out.println("Archer " + characterName + " shoots a piercing arrow for ranged damage!");
    }
}

public class AdventureGameCharacterSystem {
    public static void startBattle(GameCharacter[] characters) {
        int warriorCount = 0;
        int mageCount = 0;
        int archerCount = 0;

        System.out.println("--- Battle Initiated ---");
        for (GameCharacter c : characters) {
            c.performAttack();
            if (c instanceof Warrior) {
                warriorCount++;
            } else if (c instanceof Mage) {
                mageCount++;
            } else if (c instanceof Archer) {
                archerCount++;
            }
        }

        System.out.println("\n--- Battle Summary ---");
        System.out.println("Total Participants: " + characters.length);
        System.out.println("Warriors: " + warriorCount);
        System.out.println("Mages: " + mageCount);
        System.out.println("Archers: " + archerCount);
    }

    public static void main(String[] args) {
        GameCharacter[] squad = new GameCharacter[5];
        squad[0] = new Warrior("Thorin");
        squad[1] = new Mage("Gandalf");
        squad[2] = new Archer("Legolas");
        squad[3] = new Warrior("Conan");
        squad[4] = new Mage("Merlin");

        startBattle(squad);
    }
}
