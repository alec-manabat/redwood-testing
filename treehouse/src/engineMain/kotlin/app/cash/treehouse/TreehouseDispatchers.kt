/*
 * Copyright (C) 2022 Square, Inc.
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
package app.cash.treehouse

import kotlinx.coroutines.CoroutineDispatcher

/**
 * One of the trickiest things Treehouse needs to do is balance its two dispatchers:
 *
 *  * [main] is the [CoroutineDispatcher] that runs on the platform's main thread.
 *  * [zipline] is where downloaded code executes.
 *
 * This class makes it easier to specify invariants on which dispatcher is expected for which work.
 */
public interface TreehouseDispatchers {
  public val main: CoroutineDispatcher
  public val zipline: CoroutineDispatcher

  /**
   * Confirm that this is being called on the main thread or main dispatcher.
   *
   * @throws IllegalStateException if invoked on non-main thread.
   */
  public fun checkMain()

  /**
   * Confirm that this is being called on the zipline thread or zipline dispatcher.
   *
   * @throws IllegalStateException if invoked on non-zipline thread.
   */
  public fun checkZipline()
}