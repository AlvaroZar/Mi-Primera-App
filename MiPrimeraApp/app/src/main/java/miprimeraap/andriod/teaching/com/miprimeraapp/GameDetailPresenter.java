package miprimeraap.andriod.teaching.com.miprimeraapp;

import java.util.ArrayList;

public class GameDetailPresenter {
    private GamesInteractor interactor;
    private GameDetailView view;

    public void startPresenting(GameDetailView view){
        this.view = view;
        interactor = new GamesInteractor();
    }

    public void loadGameWithId(int id){
        GameModel game = interactor.getGameWithId(id);
        view.onGameLoaded(game);
    }
    public ArrayList<GameModel> getGames(){
        return interactor.getGames();
    }
}
