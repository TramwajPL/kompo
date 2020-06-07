package view;

import javafx.scene.Group;
import javafx.scene.shape.Line;

/**
 * interfejs ten stanowi interfejs, który jest implementowany przez klasy DippedBeamLight, FrontFogLight, HighBeamLight,
 * RearFogLight oraz SideLight.
 */

public interface Light {
    /**
     * Jest to metoda jednocześnie tworząca i zwracają obiekt klasy Group.
     * @return zwraca obiekt klasy Group reprezentujący graficznie reflektor wchodzący w skład kontrolki danego światła.
     */
    Group getHeadlight();

    /**
     * Jest to metoda jednocześnie tworząca i zwracają obiekt klasy Group.
     * @return zwraca obiekt klasy Group reprezentujący graficznie linie świateł wchodzące w skład kontrolki danego
     * światła.
     */
    Group getLines();

    /**
     * Metoda pomocnicza. Ułatwia tworzenie linii świateł poprzez zapewnienie tych samych parametrów dla każdego
     * z obiektów klasy Line.
     * @param startX początkowa współrzędna x-owa linii.
     * @param startY początkowa współrzędna y-owa linii.
     * @param endX końcowa współrzędna x-owa linii.
     * @param endY końcowa współrzędna y-owa linii.
     * @return zwraca linię o podanych parametrach.
     */
    Line createLine(int startX, int startY, int endX, int endY);

    /**
     * @return zwraca obiekt klasy Group, w którego skład wchodzi cała kontrolka danego światła.
     */
    Group getGroup();

    /**
     * Metoda odpowiedzialna za wyłączenie danej kontrolki.
     */
    void turnOff();

    /**
     * Metoda odpowiedzialna za włączenie danej kontrolki.
     */
    void turnOn();

    /**
     * Metoda, która w zależności od parametru pośrednio włącza lub wyłącza kontrolkę światła.
     * @param mode parametr typu boolean, wartość false wyłącza kontrolkę, wartość true włącza kontrolkę.
     */
    void changeMode(boolean mode);


}
