/*
 * The MIT License
 *
 * Copyright (c) 2025, CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package jenkins.diagnosis;

import hudson.Extension;
import hudson.ExtensionList;
import hudson.diagnosis.MemoryUsageMonitor;
import hudson.model.InvisibleAction;
import hudson.model.RootAction;
import jenkins.model.Jenkins;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;

/**
 * Expose {@link hudson.diagnosis.MemoryUsageMonitor#heap} at the {@code /hudson.diagnosis.MemoryUsageMonitor/heap} URL.
 *
 * @since TODO
 */
@Extension
@Restricted(NoExternalUse.class)
public class MemoryUsageMonitorAction extends InvisibleAction implements RootAction {
    @Override
    public String getUrlName() {
        return MemoryUsageMonitorAction.class.getName();
    }

    public MemoryUsageMonitor.MemoryGroup getHeap() {
        Jenkins.get().checkAnyPermission(Jenkins.SYSTEM_READ, Jenkins.MANAGE);
        return ExtensionList.lookupSingleton(MemoryUsageMonitor.class).heap;
    }
}
