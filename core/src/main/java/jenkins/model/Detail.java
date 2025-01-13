package jenkins.model;

import edu.umd.cs.findbugs.annotations.Nullable;
import hudson.model.Actionable;
import hudson.model.ModelObject;
import hudson.model.Run;
import org.jenkins.ui.icon.IconSpec;

/**
 * {@link Detail} represents a piece of information about a {@link Run}.
 * Such information could include:
 * <ul>
 *  <li>the date and time the run started</li>
 *  <li>the amount of time the run took to complete</li>
 *  <li>SCM information for the build</li>
 *  <li>who kicked the build off</li>
 * </ul>
 * @since TODO
 */
public abstract class Detail implements ModelObject, IconSpec {

    private final Actionable object;

    public Detail(Actionable object) {
        this.object = object;
    }

    public Actionable getObject() {
        return object;
    }

    /**
     * {@inheritDoc}
     */
    public @Nullable String getIconClassName() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @Nullable String getDisplayName() {
        return null;
    }

    /**
     * Optional URL for the {@link Detail}
     */
    public @Nullable String getUrl() {
        return null;
    }

    /**
     * Returns true if this detail is applicable to the given Actionable object
     */
    public boolean isApplicable() {
        return true;
    }

    /**
     * @return the grouping of the detail
     */
    public DetailGroup getGroup() {
        return DetailGroup.GENERAL;
    }

    /**
     * @return order in the group, zero is first, MAX_VALUE is any order
     */
    public int getOrder() {
        return Integer.MAX_VALUE;
    }
}
