import "./Logo.css"
import logo from "./users-logo.png"
export default function Logo() {

    return(
        <div className="div-logo">
            <h1>Assist control app</h1>
            <img src={logo} alt="users"/>
        </div>
    )
}