/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.ArrayList;

/**
 *
 * @author JoXhe
 */


//PARTE DE TABLERO - CLASS TEMPORAL
public class piezaMoves {
    public static final Position posOneMove[] = {new Position(1,-1),new Position(1,0),new Position(1,1),new Position(0,-1),new Position(0,1),new Position(-1,-1),new Position(-1,0),new Position(-1,1)};
    public static final Position posTwoMoves[] = {new Position(2,-2),new Position(2,0),new Position(2,2),new Position(0,-2),new Position(0,2),new Position(-2,-2),new Position(-2,0),new Position(-2,2)};
    public static final Position posLMove[] = {new Position(1,-2),new Position(2,-1),new Position(2,1),new Position(1,2),new Position(-1,-2),new Position(-2,-1),new Position(-2,1),new Position(-1,2)};
    
    public ArrayList<Position> getMoves(Pieza p,char tipo){
        ArrayList<Position> temp = new ArrayList();
        int x,y;
        Position move[];
        if(tipo=='1')
            move = posOneMove;
        else if(tipo=='2')
            move = posTwoMoves;
        else if(tipo=='L')
            move = posLMove;
        else
            move = null;
        
        for(Position i: move){
            x = i.x + p.getPosition().x;
            y = i.y + p.getPosition().y;
            if(x >= 0 && x <= 5 && y >= 0 && y <= 5)
                temp.add(new Position(x,y));
        }
        return temp;
    }
    
    public boolean piezaAttack(Pieza miPieza, Pieza piezaAttack){
        if(piezaAttack.tipo.equals(piezaTipo.ZOMBIE))
            return piezaAttack.setLP(miPieza.attackZombie());
        if(piezaAttack.tipo.equals(piezaTipo.WOLF))
            return piezaAttack.setLP(miPieza.attackWolf());
        if(piezaAttack.tipo.equals(piezaTipo.VAMPIRE))
            return piezaAttack.setLP(miPieza.attackVampire());
        if(piezaAttack.tipo.equals(piezaTipo.DEATH))
            return piezaAttack.setLP(miPieza.attackDeath());
        return false;
    }
    
}