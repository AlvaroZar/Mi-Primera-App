package miprimeraap.andriod.teaching.com.miprimeraapp;
import java.util.ArrayList;

public class GamesInteractor {
    private static ArrayList<GameModel>games;

    public GamesInteractor(){
        if (games == null){
            GameModel chrome = new GameModel(0,"Chrome","Descripcion Chrome",
                    "https://www.google.es/", R.mipmap.chrome, R.mipmap.google );

            GameModel pokemon = new GameModel(1,"Pokemon","Descripcion Pokemon",
                    "https://www.pokemon.com/es/videojuegos-pokemon/", R.mipmap.pokemon, R.mipmap.pokemos3 );

            games = new ArrayList<>();
            games.add(chrome);
            games.add(pokemon);
        }

    }

    public static ArrayList<GameModel> getGames() {

        return games;
    }

    public GameModel getGameWithId(int id){
        for (GameModel game:games){
            if (game.getId() == id){
                return game;
            }
        }
        return null;
    }

}

