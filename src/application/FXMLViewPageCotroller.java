package application ;

import java.net.URL ;
import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.ResultSet ;
import java.sql.Statement ;
import java.util.ResourceBundle ;

import javafx.collections.FXCollections ;
import javafx.collections.ObservableList ;
import javafx.event.ActionEvent ;
import javafx.fxml.FXML ;
import javafx.fxml.Initializable ;
import javafx.scene.control.Button ;
import javafx.scene.control.ListView ;
import javafx.scene.control.MenuButton ;
import javafx.scene.control.MenuItem ;

public class FXMLViewPageCotroller implements Initializable {

	@FXML
	private MenuButton	menuBtnSort ;

	@FXML
	private MenuButton	menuBtnAscDesc ;

	@FXML
	private Button		btnComplete ;

	@FXML
	private ListView	taskListView ;

	String				orderBy ;
	String				ascDesc ;
	ObservableList		items ;

	Connection			Connection ;
	Statement			Statement ;

	@Override
	public void initialize( URL location, ResourceBundle resources ) {
		refreshList() ;
	}

	public void refreshList() {
		Connection = null ;
		Statement = null ;

		items = FXCollections.observableArrayList() ;

		getTask(items) ;

		taskListView.setItems(items) ;
	}

	public void getTask( ObservableList observableList ) {
		// TODO Auto-generated method stub

		orderBy = menuBtnSort.getText() ;
		ascDesc = menuBtnAscDesc.getText() ;

		try
		{
			Class.forName("org.sqlite.JDBC") ;
			Connection = DriverManager.getConnection("jdbc:sqlite:first.db") ;
			Connection.setAutoCommit(false) ;
			Statement = Connection.createStatement() ;

			if (orderBy.equals("Time"))
				orderBy = "TIMING" ;
			else if (orderBy.equals("Title"))
				orderBy = "TITLE" ;
			else
				orderBy = "LOCATIONS" ;

			String querry = "SELECT * FROM Tasks ORDER BY " + orderBy
					+ " COLLATE NOCASE " + ascDesc ;
			System.out.println("Querry is : " + querry) ;

			ResultSet resultSet = Statement.executeQuery(querry) ;

			while (resultSet.next())
			{
				String title = resultSet.getString("TITLE") ;
				String location = resultSet.getString("LOCATIONS") ;
				String timing = resultSet.getObject("TIMING").toString() ;

				System.out.println("TITLE = " + title) ;
				System.out.println("LOCATION = " + location) ;
				System.out.println("TIMING = " + timing) ;
				System.out.println() ;

				items.add(title + "\t" + location + "\t" + timing) ;
			}

			resultSet.close() ;
			Statement.close() ;
			Connection.close() ;

		} catch ( Exception e )
		{
			// TODO: handle exception
			System.err.println(e.getClass().getName() + ": " + e.getMessage()) ;
		}
	}

	@FXML
	private void pressListViewAction() {
		System.out.println("Selected index: "
				+ taskListView.getSelectionModel().getSelectedIndex()) ;

	}

	@FXML
	public void sortMenuItemButtonAction( ActionEvent actionEvent ) {
		MenuItem menuItem = (MenuItem) actionEvent.getSource() ;
		menuBtnSort.setText(menuItem.getText()) ;
		refreshList() ;
	}

	@FXML
	public void ascdescMenuItemButtonAction( ActionEvent actionEvent ) {
		MenuItem menuItem = (MenuItem) actionEvent.getSource() ;
		menuBtnAscDesc.setText(menuItem.getText()) ;
		refreshList() ;
	}
}
