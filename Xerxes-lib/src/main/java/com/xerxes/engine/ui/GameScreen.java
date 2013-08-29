package com.xerxes.engine.ui;


import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Widget;
import com.xerxes.engine.game.Actor;
import com.xerxes.engine.game.GameController;
import com.xerxes.engine.game.KeyboardController;
import com.xerxes.engine.game.XKeyboardEvent;
import com.xerxes.engine.physics.CollisionModel;

import java.util.ArrayList;
import java.util.List;

public class GameScreen extends Widget {
    private DivElement divElement;
    private static final int borderWidth = 1;
    private com.xerxes.engine.ui.Position position;
    private Size size;
    private CollisionModel collisionModel;
    private List<Actor> actorList;

    public com.xerxes.engine.ui.Position getPosition() {
        return position;
    }

    public Size getSize() {
        return size;
    }

    public GameScreen(com.xerxes.engine.ui.Position position, Size size, GameController[] controllers) {
        this(position, size, "#FFFFFF", "#000000", controllers);
    }

    public GameScreen(final com.xerxes.engine.ui.Position position, final Size size, String backColor, String borderColor, final GameController[] controllers) {
        this.position = position;
        this.size = size;
        actorList = new ArrayList<Actor>();
        divElement = Document.get().createDivElement();
        divElement.getStyle().setBackgroundColor(backColor);
        divElement.getStyle().setBorderStyle(BorderStyle.SOLID);
        divElement.getStyle().setBorderColor(borderColor);
        divElement.getStyle().setBorderWidth(borderWidth, Unit.PX);
        divElement.getStyle().setPosition(Position.ABSOLUTE);
        divElement.getStyle().setTop(position.getX(), Unit.PX);
        divElement.getStyle().setLeft(position.getY(), Unit.PX);
        divElement.getStyle().setWidth(size.getWidth(), Unit.PX);
        divElement.getStyle().setHeight(size.getHeight(), Unit.PX);
        Event.addNativePreviewHandler(new Event.NativePreviewHandler() {
            @Override
            public void onPreviewNativeEvent(Event.NativePreviewEvent event) {
                NativeEvent nativeEvent = event.getNativeEvent();
                String type = nativeEvent.getType();

                if (type.equals("keydown") || type.equals("keyup")) {
                    XKeyboardEvent keyboardGameEvent = new XKeyboardEvent(nativeEvent.getKeyCode(), type);
                    for (GameController controller : controllers) {
                        if (controller instanceof KeyboardController) controller.receiveEvent(keyboardGameEvent);
                    }
                }

            }
        });
        setElement(divElement);
        this.setVisible(false);
        final Timer t = new Timer() {
            @Override
            public void run() {
                for (int counter = 0; counter < actorList.size(); counter++) {
                    Actor currentActor = actorList.get(counter);
                    com.xerxes.engine.ui.Position spritePosition = currentActor.getSprite().getPosition();
                    double screenBorderX = size.getWidth();
                    if (spritePosition.getX() > screenBorderX || spritePosition.getX() < 0) {

                    }
                }
            }
        };
        t.scheduleRepeating(100);
    }

    public void render() {
        if (!this.isVisible()) this.setVisible(true);
    }

    public void addActor(Actor actor) {
        this.addSprite(actor.getSprite());
        actorList.add(actor);
    }

    public void addSprite(Spriteable sprite) {
        divElement.appendChild(sprite.getContainer());
    }
}
