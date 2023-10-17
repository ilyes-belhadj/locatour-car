/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;

/**
 *
 * @author Asus
 * @param <Reservation>
 */
public interface Ireservation<Reservation> {

    public boolean ajouter(Reservation r);

    public boolean modifierReservation(Reservation r, int idR);

    public boolean SupprimerReservation(int id);

    public List<Reservation> AfficherReservations();

}
