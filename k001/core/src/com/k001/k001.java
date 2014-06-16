package com.k001;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

//Обьявление класса. Обратите внимание, что он реализует интерфейс ApplicationListener. В
//вашей игре должен быть по крайней игре один класс, который реализует такой интерфейс.
//Чуть позже я обьясню, где этот класс использовать
public class k001 implements ApplicationListener {
    //текстура карт
    private Texture cardsClub;
    private Texture cardsDiamond;
    private Texture cardsHeart;
    private Texture cardsSpade;
    //оотрисовка
    private SpriteBatch batch;

    @Override
    public void create() {
        cardsClub = new Texture("data/cards_clubs.png");
        cardsDiamond = new Texture("data/cards_diamonds.png");
        cardsHeart = new Texture("data/cards_hearts.png");
        cardsSpade = new Texture("data/cards_spades.png");
        batch = new SpriteBatch();

    }

    //Этот метод вызывается, когда игра закрывается - мы очищаем ресурсы, которые не собираються сборщиком мусора
    @Override
    public void dispose() {

    }

    //Этот метод вызывается каждый кадр отрисовки. Заметьте, частота его вызова непостоянна - FPS может "прыгать"
    @Override
    public void render() {
        batch.begin();
        for(int i=0;i<13;i++) {
            //SpriteBatch.draw(com.badlogic.gdx.graphics.Texture, float, float, int, int, int, int)()
            batch.draw(cardsClub, 20+(35+10)*i, 100, 50, 35, 0+i*71, 0, 70, 93, false, false);//, 93, 70*(i+1));
            batch.draw(cardsDiamond, 20+(35+10)*i, 200, 50, 35, 0+i*71, 0, 70, 93, false, false);//, 93, 70*(i+1));
            batch.draw(cardsHeart, 20+(35+10)*i, 300, 50, 35, 0+i*71, 0, 70, 93, false, false);//, 93, 70*(i+1));
            batch.draw(cardsSpade, 20+(35+10)*i, 400, 50, 35, 0+i*71, 0, 70, 93, false, false);//, 93, 70*(i+1));
        }
        /*
        batch.draw(cardsTexture, 100, 50, 150, 150);
        batch.draw(cardsTexture, 270, 100, 200, 200);
        */
        batch.end();
    }

    //Этот метод вызывается, когда мы изменяем размеры окна - то есть, только в desktop режиме
    @Override
    public void resize(int width, int height) {
    }

    //Когда мы на телефоне сворачиваем приложение, или нам поступает звонок - вызывается этот метод.
    //Также он вызывается перед закрытием игры на всех платформах
    @Override
    public void pause() {
    }

    //Когда мы на телефоне открываем уже запущенное приложение - вызывается этот метод
    @Override
    public void resume() {
    }
}