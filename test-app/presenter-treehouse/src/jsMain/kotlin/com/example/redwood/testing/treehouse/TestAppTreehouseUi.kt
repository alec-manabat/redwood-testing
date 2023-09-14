/*
 * Copyright (C) 2023 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.redwood.testing.treehouse

import androidx.compose.runtime.Composable
import app.cash.redwood.treehouse.TreehouseUi
import com.example.redwood.testing.presenter.HttpClient
import com.example.redwood.testing.presenter.RepoSearch

class TestAppTreehouseUi(
  private val httpClient: HttpClient,
) : TreehouseUi {
  @Composable
  override fun Show() {
    RepoSearch(httpClient)
  }
}