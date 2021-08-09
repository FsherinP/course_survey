import React, { useState, useEffect } from "react";

function SurveyData() {
  const [stateData, setState] = useState([]);

  const fetchData = () => {
    return fetch("http://localhost:9083/course-survey/get-data").then(
      (response) => response.json()
    );
    
  };

  useEffect(() => {
    fetchData().then((data) => {
     
      setState(data.response);
    });
    console.log(stateData);
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  const formList = (list, index) => {
    return (
      <tr key={index}>
        <td>{index + 1}</td>  
        <td>{list.rating}</td>
        <td>{list.comments}</td>
        <td>{list.topic}</td>
      </tr>
    );
  };

  return (
      <div className="d-flex justify-content-center align-items-center m-4">
          
    <table className="table w-75">
      <thead>
        <tr>
          <th scope="col">No</th>
          <th scope="col">Rating</th>
          <th scope="col">Comments</th>
          <th scope="col">Topic</th>
        </tr>
      </thead>
      <tbody>
        {stateData.map(formList)}
       
      </tbody>
    </table>
      </div>
  );
}

export default SurveyData;
