package Repositorys;

import Person.Customer.payingCustomer.Ticket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TICKETS.*;

import java.sql.*;

public class RepTicket implements IRepTicket {
    private String url = "jdbc:mysql://localhost/skisoftware";
    private String user = "root";
    private String password = "xz89F1";
    private Connection _connection;

    public RepTicket() throws ClassNotFoundException {

        Class<?> c = Class.forName("com.mysql.cj.jdbc.Driver");
        if (c != null) {
            System.out.println("MySQL-Treiber wurde geladen!");
        }
    }

    @Override
    public void open() throws SQLException {
        this._connection = DriverManager.getConnection(url, user, password);

    }

    @Override
    public void close() throws SQLException {
        if ((this._connection != null) && (!this._connection.isClosed())) {
            // .... wird geschlossen
            this._connection.close();
            System.out.println("Verbindung wurde geschlossen!");
        }

    }


    @Override
    public boolean insertTicket(allgemeinesTicket ticket) throws SQLException {
        PreparedStatement pStmt = this._connection.prepareStatement("insert into tickets values(?,?,?,?,?)");
        pStmt.setInt(1, ticket.getTicketId());
        pStmt.setInt(2, ticket.gettypeOfTicket().ordinal());
        pStmt.setString(3,ticket.getTicketName());
        pStmt.setDate(4, (Date) ticket.getDatum());
        pStmt.setDouble(5,ticket.getPrice());


        return pStmt.executeUpdate() == 1;
    }

    @Override
    public boolean deleteTicket(int ticketId) throws SQLException {
        return false;
    }

    @Override
    public boolean updateTicket(int ticketId, allgemeinesTicket newTicketData) throws SQLException {
        return false;
    }
    private TypeOfTicket INTOtypeOfTicket(int tot){
        switch (tot){
            default:
                return TypeOfTicket.NichtFestgelegt;
            case 1:
                return TypeOfTicket.Halbtagesticket;
            case 2:
                return TypeOfTicket.Dreistundenticket;
            case 3:
                return TypeOfTicket.Tagesticket;
            case 4:
                return TypeOfTicket.Saisonticket;
        }
    }

    @Override
    public List<allgemeinesTicket> allTickets() throws SQLException {
        List <allgemeinesTicket> tickets = new ArrayList<>();
        PreparedStatement pStmt = this._connection.prepareStatement("select  * from allgeTickets");
        ResultSet set = pStmt.executeQuery();
        allgemeinesTicket at1;
        while (set.next()){
            at1 = new allgemeinesTicket();
            at1.setTicketId(set.getInt("ticketId"));
            at1.setTypeOfTicket(INTOtypeOfTicket(set.getInt("typeOfTicket")));
            at1.setTicketName(set.getString("ticketName"));
            at1.setDatum(set.getDate("datum"));
            at1.setPrice(set.getDouble("price"));

            tickets.add(at1);

        }
        if(tickets.size()>=1){
            return tickets;
        }
        else {
            System.out.println("NIX DRINE IN TICKETS ALLGEMEIN");
            return null;
        }

    }

    @Override
    public List<tagesTicket> alltagesTicket() throws SQLException {
        List <tagesTicket> tickets = new ArrayList<>();
        PreparedStatement pStmt = this._connection.prepareStatement("select ticketId,typeOfTicket,ticketName,datum,price,beginnZeit,endZeit from tagesTicket as tt join allgeTickets as at on tt.tagesTiId = at.ticketId;");
        ResultSet result =pStmt.executeQuery();
        tagesTicket tt1;
        while(result.next()){
            tt1 = new tagesTicket();
            tt1.setTicketId(result.getInt("ticketId"));
            tt1.setBeginn(result.getTime("beginnZeit"));
            tt1.setEndzeit(result.getTime("endZeit"));
            tt1.setTypeOfTicket(INTOtypeOfTicket(result.getInt("typeOfTicket")));
            tt1.setTicketName(result.getString("ticketName"));
            tt1.setDatum(result.getDate("datum"));
            tt1.setPrice(result.getDouble("price"));
            tickets.add(tt1);
        }
        if(tickets.size()>=1){
            return tickets;

        }
        else {
            System.out.println("NIX DRINE IN TICKETS TAGES");
            return null;
        }
    }
}
