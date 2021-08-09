import React from "react";
import { useForm } from "react-hook-form";
import { useHistory  } from 'react-router-dom';


function SurveyForm() {
  const { register, handleSubmit } = useForm();
  const history = useHistory();
  const onSubmit = (data) => {
    
      
      const user = {
          "comments": data.comments,
          "rating": data.rating,
          "topic": data.topic
        }
        console.log(JSON.stringify({user}),);

  
    fetch('http://localhost:9083/course-survey/survey-data', {
        method: 'POST',
        body: JSON.stringify({user}),
        headers: { 'Content-Type': 'application/json' },
      })
        .then(res => {res.json()
        history.push('/data')}
        )
        
  };

  return (
    <div
      className=""
      style={{
        justifyContent: "center",
        display: "flex",
        alignItems: "center",
        height: "100vh",
      }}
    >
      <form
        onSubmit={handleSubmit(onSubmit)}
        className="card p-3 d-flex flex-column justify-content-center align-items-center"
        style={{
            width: "500px",
            gap: "20px",
        }}
        >
          <h3 >Course Survey</h3>
        <div className="d-flex flex-column w-75 gap-1 ">
          <label className="form-label">Choose the course title</label>
          <select  className="form-select"{...register("topic")}>
            <option value="Introduction to Economis">
              Introduction to Economis
            </option>
            <option value="IAS">IAS</option>
            <option value="IPS">IPS</option>
          </select>
        </div>
        <div className="w-75 d-flex flex-column gap-1">
        <label className="form-label" > How will you rate this course</label>
        <div className="d-flex gap-1 align-items-center" >
            
          <input {...register("rating")} type="radio" value="Good" />
          <label>Good</label>
          <input {...register("rating")} type="radio" value="Excellent" />
          <label>Excelent</label>
          <input {...register("rating")} type="radio" value="outstanding" />
          <label>Outstanding</label>
        </div>
        </div>

        <div className="d-flex flex-column w-75 gap-1">
          <label className="form-label">Any other comments</label>

          <textarea className="form-control "{...register("comments", {})} />
        </div>
        <button type="submit"  className=" btn btn-primary w-25">Submit</button>
      </form>
    </div>
  );
}

export default SurveyForm;
