import { useState, useEffect } from "react";
import ContactTable from "../components/ContactTable";

const fetchContacts = () => {
    return fetch("contacts").then((res) => res.json());
};

const createContact = (contact) => {
    return fetch("contacts", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(contact),
    }).then((res) => res.json());
};

const Contacts = () => {
    const [contacts, setContacts] = useState([]);
    const [name, setName] = useState(null);
    const [phoneNumber, setPhoneNumber] = useState([]);

    useEffect(() => {
        fetchContacts().then((contacts) => {
            setContacts(contacts)
        })
    }, []);

    const handleCreate = (e) => {
        e.preventDefault();
        createContact({ name, phoneNumber });

    }

    return (
        <div>
            <ContactTable contacts={contacts} />
            <form className='ContactForm' onSubmit={handleCreate}>
                <div>
                    <label htmlFor="name">Name:</label>
                    <input
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                        name="name"
                        id="name"
                    />
                </div>
                <div>
                    <label htmlFor="phoneNumber">Phone number:</label>
                    <input
                        value={phoneNumber}
                        onChange={(e) => setPhoneNumber(e.target.value)}
                        name="phoneNumber"
                        id="phoneNumber"
                    />
                </div>
                <div className="button">
                    <button type="submit" >Add</button>
                </div>
            </form>
        </div>
    );


};

export default Contacts;