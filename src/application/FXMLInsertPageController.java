package application ;

import java.io.IOException ;
import java.net.URL ;
import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.Statement ;
import java.time.LocalDate ;
import java.time.format.DateTimeFormatter ;
import java.util.ResourceBundle ;

import javafx.event.ActionEvent ;
import javafx.fxml.FXML ;
import javafx.fxml.FXMLLoader ;
import javafx.fxml.Initializable ;
import javafx.scene.Node ;
import javafx.scene.Parent ;
import javafx.scene.Scene ;
import javafx.scene.control.Button ;
import javafx.scene.control.DatePicker ;
import javafx.scene.control.TextArea ;
import javafx.scene.control.TextField ;
import javafx.stage.Stage ;
import jfxtras.scene.control.LocalTimePicker ;

public class FXMLInsertPageController implements Initializable {

	private int		Min ;
	private int		Hour ;
	private String	AmPm ;

	@FXML
	TextField		titleText ;

	@FXML
	TextField		locationText ;

	@FXML
	TextArea		notesText ;

	@FXML
	LocalTimePicker	timePicker ;

	@FXML
	DatePicker		datePicker ;

	@FXML
	Button			btn_done ;

	@FXML
	public void doneButtonHandler( ActionEvent event ) throws IOException {
		String time = timePicker.getLocalTime().format(
				DateTimeFormatter.ISO_TIME) ;

		convert24HourTime(time) ;

		if (AmPm.equals("PM"))
			Hour += 12 ;

		if (datePicker.getValue() == null)
			datePicker.setValue(LocalDate.now()) ;
		String qurey = "INSERT INTO Tasks (TITLE,LOCATIONS,NOTES,TIMING) VALUES ("
				+ "'"
				+ titleText.getText()
				+ "',"
				+ "'"
				+ locationText.getText()
				+ "',"
				+ "'"
				+ notesText.getText()
				+ "',"
				+ "'"
				+ datePicker.getValue()
				+ " "
				+ Hour
				+ ":"
				+ Min
				+ ":00" + "')" ;

		insertStatement(qurey) ;
		returnHomePage(event) ;
	}

	public void insertStatement( String resources ) {
		Connection connection = null ;
		Statement statement = null ;

		try
		{
			connection = DriverManager.getConnection("jdbc:sqlite:first.db") ;
			connection.setAutoCommit(false) ;

			System.out.println("Opening Database Successful") ;

			statement = connection.createStatement() ;

			System.out.println("Our Querry : " + resources) ;

			statement.executeUpdate(resources) ;

			statement.close() ;
			connection.commit() ;
			connection.close() ;

		} catch ( Exception e )
		{
			System.err.println(e.getClass().getName() + " : " + e.getMessage()) ;
		}
	}

	public void returnHomePage( ActionEvent event ) throws IOException {

		Parent HomePageParent = FXMLLoader.load(getClass().getResource(
				"FXMLHomePage.fxml")) ;

		Scene HomePageScene = new Scene(HomePageParent) ;
		Stage AppStage = (Stage) ((Node) event.getSource()).getScene()
				.getWindow() ;

		AppStage.setScene(HomePageScene) ;
		AppStage.show() ;
	}

	@Override
	public void initialize( URL location, ResourceBundle resources ) {
		// TODO Auto-generated method stub
		Min = 0 ;
		Hour = 0 ;
		AmPm = "" ;

	}

	public void convert24HourTime( String time ) {
		String[] times = time.split(":") ;

		int hour = Integer.parseInt(times[0]) ;
		int min = Integer.parseInt(times[1]) ;

		this.Min = min ;

		if ((hour >= 0) && (hour < 12))
			AmPm = "AM" ;
		else
			AmPm = "PM" ;

		if (hour == 0)
			this.Hour = 12 ;
		else if ((hour > 12) && (hour < 24))
			this.Hour = hour - 12 ;
		else
			this.Hour = hour ;
	}
}
