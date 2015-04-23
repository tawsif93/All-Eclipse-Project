package application ;

import java.io.IOException ;
import java.net.URL ;
import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.ResultSet ;
import java.sql.Statement ;
import java.util.ResourceBundle ;

import javafx.event.ActionEvent ;
import javafx.fxml.FXML ;
import javafx.fxml.FXMLLoader ;
import javafx.fxml.Initializable ;
import javafx.scene.Node ;
import javafx.scene.Parent ;
import javafx.scene.Scene ;
import javafx.scene.control.Button ;
import javafx.scene.control.Label ;
import javafx.scene.control.TextField ;
import javafx.scene.input.KeyCode ;
import javafx.scene.input.KeyEvent ;
import javafx.stage.Stage ;

public class FXMLDocumentController implements Initializable {

	@FXML
	Button		btn_login ;

	@FXML
	TextField	box_username ;

	@FXML
	TextField	box_password ;

	@FXML
	Label		lbl_invalid ;

	@FXML
	public void passwordLabelPressListener( KeyEvent event ) {

		if (event.getCode().equals(KeyCode.ENTER))
		{
			btn_login.fire() ;
		}
	}

	@FXML
	public void loginButtonPressListener( KeyEvent event ) {

		if (event.getCode().equals(KeyCode.ENTER))
		{
			btn_login.fire() ;
		}
	}

	@FXML
	public void usernameLabelPressListener( KeyEvent event ) {

		if (event.getCode().equals(KeyCode.ENTER))
		{
			box_password.requestFocus() ;
			;
		}
	}

	@FXML
	public void handleButtonAction( ActionEvent event ) throws IOException {
		System.out.println("You Clicked Me") ;

		Parent HomePageParent = FXMLLoader.load(getClass().getResource(
				"FXMLHomePage.fxml")) ;

		Scene HomePageScene = new Scene(HomePageParent) ;
		Stage AppStage = (Stage) ((Node) event.getSource()).getScene()
				.getWindow() ;

		if (isValid())
		{
			AppStage.setScene(HomePageScene) ;
			AppStage.show() ;

		}
		else
		{
			box_username.clear() ;
			box_password.clear() ;
			lbl_invalid.setText("Sorry , Try Again") ;
		}
	}

	@Override
	public void initialize( URL arg0, ResourceBundle arg1 ) {
		// TODO Auto-generated method stub

	}

	public boolean isValid() {
		boolean letIn = false ;

		String querry = "Select * FROM users WHERE USERNAME= " + "'"
				+ box_username.getText() + "'" + " AND PASSWORD= " + "'"
				+ box_password.getText() + "'" ;

		System.out.println(querry) ;

		Connection connection = null ;
		Statement statement = null ;

		try
		{
			connection = DriverManager.getConnection("jdbc:sqlite:first.db") ;
			connection.setAutoCommit(false) ;

			statement = connection.createStatement() ;

			ResultSet resultSet = statement.executeQuery(querry) ;

			while (resultSet.next())
			{
				if ((resultSet.getString("USERNAME") != null)
						&& (resultSet.getString("PASSWORD") != null))
				{
					String username = resultSet.getString("USERNAME") ;
					System.out.println("USERNAME = " + username) ;
					String password = resultSet.getString("PASSWORD") ;
					System.out.println("PASSWORD = " + password) ;
					letIn = true ;
				}
			}
			resultSet.close() ;
			statement.close() ;
			connection.close() ;

		} catch ( Exception e )
		{
			// TODO: handle exception
			System.err.println(e.getClass().getName() + " : " + e.getMessage()) ;
		}

		System.out.println("Done Successfully") ;
		return letIn ;
	}
}
