package controller.user;
import controller.FrameController;
import model.user.UserManager;
import view.main.MainFrame;
import view.user.SignUpFrame;
import javax.swing.*;
import java.sql.SQLException;

/**
 * Controller for managing the SignInFrame.
 *
 * @author Beata Keresztes
 */
public class SignInController extends FrameController {

  /** An instance of the UserManager which manages the data in the model User. */
  UserManager userManager;
  /**
   * The signInFlag is used to notify the windowAdapter whether the frame is closing because of a
   * successful sign-in or because the user exited the application.
   */
  private boolean signInFlag;
  /** Messages displayed to inform the user about the sign in's validation. */
  private static final String WRONG_SIGN_IN_CREDENTIALS_MESSAGE = "Wrong credentials!";
  private static final String INVALID_SIGN_IN_MESSAGE =
      "Invalid sign in! \nCheck that the username and password\nthat you introduced are correct!";

  public SignInController(JFrame signInFrame) {
    super(signInFrame);
    signInFlag = false;
    userManager = UserManager.getInstance();
  }

  public boolean getSignInFlag() {
    return signInFlag;
  }

  /**
   * Check if the username and password introduced are correct.
   *
   * @param username = the username introduced by the user
   * @param password = the password introduced by the user
   * @return boolean = true, if the username and password are correct
   */
<<<<<<< HEAD
  public boolean validateSignIn(String username, String password) {
      try {
        if(isNotEmptyText(username) && isNotEmptyText(password)) {
          return userManager.signIn(username, password);
        }
      }catch(SQLException sqlException) {
        super.displayDatabaseErrorDialog();
=======
  public boolean isValidSignIn(String username, String password) {
    if (isNotEmptyText(username) && !isNotEmptyText(password)) {
      try {
        return userManager.signIn(username, password);
      } catch (SQLException sqlException) {
        return false;
>>>>>>> b1b4c0df00f32dfd17af508a5ad978a0cf65a26a
      }
      return false;
  }
<<<<<<< HEAD
  /**
   * Checks if the text from the text-field is not empty.
   */
=======
  /** Checks if the text from the text-field is empty. */
>>>>>>> b1b4c0df00f32dfd17af508a5ad978a0cf65a26a
  private boolean isNotEmptyText(String text) {
    return !(text == null || text.isEmpty());
  }

  /** Opens the main menu on successful sign-in. */
  public void enableSigningIn() {
    new MainFrame();
    signInFlag = true;
    closeFrame();
  }

  /** Opens a new Frame for the User to sign up, also it disables and hides the current frame. */
  public void enableSigningUp() {
    new SignUpFrame(super.frame);
    frame.setVisible(false);
    frame.setEnabled(false);
  }
  /** Display an error message in case of an unsuccessful sign-in attempt. */
  public void displayInvalidSignInDialog() {
    JOptionPane.showMessageDialog(
        frame,
        INVALID_SIGN_IN_MESSAGE,
        WRONG_SIGN_IN_CREDENTIALS_MESSAGE,
        JOptionPane.WARNING_MESSAGE);
  }

}
