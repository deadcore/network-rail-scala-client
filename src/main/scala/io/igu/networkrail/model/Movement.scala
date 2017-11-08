/*
 * Copyright (c) 2017 igu.io. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.igu.networkrail.model

case class Movement(event_type: String,
                    gbtt_timestamp: String,
                    original_loc_stanox: String,
                    planned_timestamp: String,
                    timetable_variation: String,
                    original_loc_timestamp: String,
                    current_train_id: String,
                    delay_monitoring_point: String,
                    next_report_run_time: String,
                    reporting_stanox: String,
                    actual_timestamp: String,
                    correction_ind: String,
                    event_source: String,
                    train_file_address: String,
                    platform: String,
                    division_code: String,
                    train_terminated: String,
                    train_id: String,
                    offroute_ind: String,
                    variation_status: String,
                    train_service_code: String,
                    toc_id: String,
                    loc_stanox: String,
                    auto_expected: String,
                    direction_ind: String,
                    route: String,
                    planned_event_type: String,
                    next_report_stanox: String,
                    line_ind: String)