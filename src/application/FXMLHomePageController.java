package application ;

import java.io.IOException ;
import java.net.URL ;
import java.util.ResourceBundle ;

import javafx.event.ActionEvent ;
import javafx.fxml.FXML ;
import javafx.fxml.FXMLLoader ;
import javafx.fxml.Initializable ;
import javafx.scene.Node ;
import javafx.scene.Parent ;
import javafx.scene.Scene ;
import javafx.scene.control.Button ;
import javafx.stage.Stage ;

public class FXMLHomePageController implements Initializable {

	@FXML
	Button	btn_insert ;

	@FXML
	Button	btn_viewTask ;

	@FXML
	public void insertButtonHandler( ActionEvent event ) throws IOException {

		System.out.println("insert Button") ;

		Parent insertPageParent = FXMLLoader.load(getClass().getResource(
				"FXMLInsertPage.fxml")) ;
		Scene insertPageScene = new Scene(insertPageParent) ;
		Stage insertPageStage = (Stage) ((Node) event.getSource()).getScene()
				.getWindow() ;

		insertPageStage.setScene(insertPageScene) ;
		insertPageStage.show() ;
	}

	@FXML
	public void viewTaskButtonHandler( ActionEvent actionEvent )
			throws IOException {
		System.out.println("Button View Task") ;

		Parent ViewTaskParent = FXMLLoader.load(getClass().getResource(
				"FXMLViewPage.fxml")) ;
		Scene viewTaskScene = new Scene(ViewTaskParent) ;
		Stage viewTaskStage = (Stage) ((Node) actionEvent.getSource())
				.getScene().getWindow() ;

		viewTaskStage.setScene(viewTaskScene) ;
		viewTaskStage.show() ;
	}

	@Override
	public void initialize( URL location, ResourceBundle resources ) {
		// TODO Auto-generated method stub

	}

}
