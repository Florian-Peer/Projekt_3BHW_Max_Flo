package Repositorys;
import TICKETS.*;


import java.sql.SQLException;
import java.util.List;
// TODO: 04.05.2022 Tages hat die allgemeinen Klassen
// TODO: 04.05.2022 Alles in ein REP

public interface IRepTicket {

    void open() throws SQLException;

    void close() throws SQLException;


    boolean insertTicket(allgemeinesTicket ticket) throws SQLException;

    boolean deleteTicket(int ticketId) throws SQLException;

    boolean updateTicket(int ticketId, allgemeinesTicket newTicketData) throws SQLException;

    List<allgemeinesTicket> allTickets() throws SQLException;

    List<tagesTicket> alltagesTicket() throws SQLException;

    List<saisonTicket> allSaisonTicket() throws SQLException;

}
