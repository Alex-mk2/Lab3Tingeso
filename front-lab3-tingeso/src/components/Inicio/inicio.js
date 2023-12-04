import React from "react";
import { Link } from 'react-router-dom';
import NavBar, { styles } from '../NavBar/NavBar';
import './inicio.css';  // Asegúrate de importar tus estilos locales si es necesario

const CardContainer = ({ title, description, linkTo, buttonText, children }) => {
  const customStyles = {
    card: {
      background: '#f5f5f5',
      border: '1px solid #ddd',
      borderRadius: '8px',
      padding: '20px',
      textAlign: 'center',
      boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)',
    },
    cardTitle: {
      color: '#333',
      marginBottom: '10px',
    },
    cardText: {
      color: '#666',
      marginBottom: '20px',
    },
    button: {
      backgroundColor: '#4CAF50',
      color: '#fff',
      padding: '10px 20px',
      border: 'none',
      borderRadius: '5px',
      cursor: 'pointer',
      fontSize: '16px',
    },
  };

  return (
    <div style={{ ...customStyles.card, ...styles.card }}>
      <h2 style={customStyles.cardTitle}>{title}</h2>
      <p style={customStyles.cardText}>{description}</p>
      <Link to={linkTo}>
        <button style={{ ...customStyles.button, ...styles.button }}>{buttonText}</button>
      </Link>
      {children}
    </div>
  );
};

const Inicio = () => {
  return (
    <>
      <NavBar />
      <div style={styles.container}>
        <h1 style={styles.title}>Loa 2.0</h1>
        <div style={styles.cardContainer}>
          <CardContainer
            title="Registrar horarios"
            description="Registra tus horarios aquí"
            linkTo="/ingresoHorarios"
            buttonText="Registrar"
          />
        </div>
      </div>
    </>
  );
}

export default Inicio;
