import { useState, useEffect } from "react";
import ContactTable from "../components/ContactTable";

const fetchContacts = () => {
    return fetch("contacts").then((res) => res.json());
  };

const Contacts = ()=>{
    const [contacts, setContacts] = useState([]);

    useEffect(()=> {
        fetchContacts().then((contacts)=> {
            setContacts(contacts)
        })
    },[]);

return(
    <ContactTable contacts={contacts}/>
);
    

};

export default Contacts;