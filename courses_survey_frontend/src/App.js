import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import './App.css';
import SurveyForm from './components/surveyform/surveyForm';
import SurveyData from './components/surveydata/surveyData';

function App() {
  return (
   
    <BrowserRouter>
    <Switch>
        <Route exact path="/" component={SurveyForm} />
        <Route path="/data" component={SurveyData}></Route>

    </Switch>
    </BrowserRouter>
  );
}

export default App;
