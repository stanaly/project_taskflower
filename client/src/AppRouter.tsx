import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import {Home} from "./page/home/Home";
import {Login} from "./page/auth/Login";
import {Signup} from "./page/auth/Signup";
import {Dashboard} from "./page/dashboard/Dashboard";
import {Calendar} from "./page/calendar/Calendar";
import {Routine} from "./page/routine/Routine";
import {Task} from "./page/task/Task";
import React from "react";
import {Report} from "./page/report/Report";
import {Setting} from "./page/setting/Setting";

export const AppRouter = (): React.JSX.Element => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/login" element={<Login/>}/>
                <Route path="/signup" element={<Signup/>}/>
                <Route path="/dashboard" element={<Dashboard/>}/>
                <Route path="/calendar" element={<Calendar/>}/>
                <Route path="/routine" element={<Routine/>}/>
                <Route path="/task" element={<Task/>}/>
                <Route path="/report" element={<Report/>}/>
                <Route path="/setting" element={<Setting/>}/>
            </Routes>
        </Router>
    );
}