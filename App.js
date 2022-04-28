import logo from './logo.png';
import './App.css';

function App() {
  const renderForm = (
    <div className="form">
      <form>
      <div className="button-container">
          <button className="left-button">Log In</button>
          <button className="right-button">Forgot <br/> password</button>
        </div>
        <div className="input-container">
          <input type="text" name="uname" placeholder="username" />
        </div>
        <div className="input-container">
          <input type="password" name="pass" placeholder="password" />
        </div>
      </form>
      <a className="new-account">Create new account</a>
    </div>
  );
  const renderRegisterForm = (
    <div className="form">
      <form>
      <div className="input-container">
          <input type="text" name="uname" placeholder="username" />
      </div>
      <div className="input-container">
          <input type="text" name="email" placeholder="email" />
      </div>
      <div className="input-container">
          <input type="password" name="pass" placeholder="password" />
      </div>
      <div className="input-container">
          <input type="password" name="confpass" placeholder="confirm password" />
      </div>
      <div className="input-container">
          <input type="text" name="fname" placeholder="first name" />
      </div>
      <div className="input-container">
          <input type="text" name="lname" placeholder="last name" />
      </div>
      <div className="input-container">
          <input type="text" name="city" placeholder="city" />
      </div>
      <div className="input-container">
          <input type="text" name="country" placeholder="country" />
      </div>
      <div className="button-container">
          <button className="left-button">Already <br/> user</button>
          <button className="right-button">Register</button>
      </div>
        
      </form>
    </div>
  );
  return (
    <div className="ipet">
      <header className="ipet-header">
        <img src={logo} className="ipet-logo" alt="logo" />
        {renderForm}
      </header>
    </div>
  );
}

export default App;
