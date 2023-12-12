import React from "react";
import { Link } from 'react-router-dom';
import NavBar, { styles } from '../NavBar/NavBar';
import './inicio.css';
import Anuncio from '../Images/59270949-icono-de-cuaderno-y-lápiz-con-larga-sombra.jpg';
import Programa from '../Images/importancia-plan-de-estudio.jpg';
import Calendario from '../Images/images.jfif';

const CardContainer = ({ title, description, linkTo, buttonText, children, imageSrc }) => {
  const customStyles = {
    card: {
      background: '#f5f5f5',
      border: '1px solid #ddd',
      borderRadius: '8px',
      padding: '10px',  // Ajusta el padding para hacer las cajas más pequeñas
      textAlign: 'center',
      boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)',
      maxWidth: '220px',  // Agrega un ancho máximo para limitar el tamaño
      margin: '0 10px 20px',  // Agrega un margen para separar las cajas
      flexDireccion: 'column',
      justifyContent: 'center',
    },
    cardTitle: {
      color: '#333',
      marginBottom: '10px',
    },
    cardContent:{
      textAlign: 'center',
      alignContent: 'center',
    },
    cardText: {
      color: '#666',
      marginBottom: '20px',
    },
    cardImage: {
      width: '70%',  
      borderRadius: '6px', 
      marginBottom: '8px',  
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
    <div style={{ ...customStyles.card }}>
      <h2 style={customStyles.cardTitle}>{title}</h2>
      {imageSrc && <img src={imageSrc} alt={title} style={customStyles.cardImage} />}
      <p style={customStyles.cardText}>{description}</p>
      <Link to={linkTo}>
        <button style={{ ...customStyles.button }}>{buttonText}</button>
      </Link>
      {children}
    </div>
  );
};

const Inicio = () => {
  const flexContainerStyles = {
    display: 'flex',  // Utilizar el modelo de caja flexible (flexbox)
    justifyContent: 'center',  // Distribuir el espacio entre los elementos
    overflowX: 'auto',  // Habilitar el desplazamiento horizontal si es necesario
  };

  return (
    <>
      <NavBar />
      <div style={styles.container}>
        <h1>

        </h1>
        <div style={{ ...styles.cardContainer, ...flexContainerStyles }}>
          <CardContainer
            title="Anuncios importantes"
            description="Anuncios importantes con respecto a inscribir ramos"
            imageSrc={Anuncio}
            buttonText="Leer más"
          />
          <CardContainer
            title="Programas de estudio"
            description="Toda la información con respecto a los programas de estudio"
            imageSrc={Programa}
            buttonText="Explorar"
          />
          <CardContainer
            title="Calendario académico"
            description="Información sobre el calendario académico"
            imageSrc={Calendario}
            buttonText="Explorar"
          />
        </div>
      </div>
    </>
  );
}

export default Inicio;